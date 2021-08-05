package ua.com.alevel;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Pattern;

public class StringTest {

    public void run() {
        String s = "test";
        s = "test1";
        String s2 = "test";
        String s1 = new String("test");

        String name = " Vadim  ";
        System.out.println("name = " + name.length());
        name = name.trim();
        System.out.println("name = " + name.length());
        name = name.toLowerCase();
        System.out.println("name = " + name);
        name = name.toUpperCase();
        System.out.println("name = " + name);
        boolean b = name.contains("A");
        System.out.println("b = " + b);
        int i = name.indexOf("A");
        System.out.println("i = " + i);
        String email = "test@gmail.com";
        String startEmail = email.split("@")[0];
        System.out.println("startEmail = " + startEmail);

        char[] chars = name.toCharArray();
        for (char aChar : chars) {
            System.out.println("aChar = " + aChar);
        }

        String empty = "   ";
        String blank = "  \t  \n";

        System.out.println("empty = " + !empty.isEmpty());
        System.out.println("blank = " + !blank.isBlank());

        System.out.println("empty = " + StringUtils.isNotEmpty(empty));
        System.out.println("blank = " + StringUtils.isNotBlank(blank));

        String regex = "^(\\d+)$";
        String number = "12345";
        if (Pattern.matches(regex, number)) {
            Integer integer = Integer.parseInt(number);
            System.out.println("integer = " + integer);
        }

        char c = name.charAt(0);
        System.out.println("c = " + c);

        int code = name.codePointAt(0);
        System.out.println("code = " + code);

        email = "test@gmail.com";
        i = email.lastIndexOf("@");
        System.out.println("i = " + i);
        String test = email.substring(0, i);
        System.out.println("test = " + test);

        String replace = "XXX123XXX456";
        replace = replace.replaceAll("XXX", "_");
        System.out.println("replace = " + replace);

        String reverse = "123456";
        StringBuilder stringBuilder = new StringBuilder(reverse);
        stringBuilder.reverse();
        reverse = stringBuilder.toString();
        System.out.println("reverse = " + reverse);

        String s5 = "test";
        String s6 = new String("test");

        boolean res = s5 == s6;
        System.out.println("res = " + res);
    }

    public void banchmark() {
        int size = 10_000;
        String s = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            s += i;
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("finish string = " + end);

        StringBuilder stringBuilder = new StringBuilder();
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(i);
        }
        end = System.currentTimeMillis() - start;
        System.out.println("finish stringBuilder = " + end);
    }
}
