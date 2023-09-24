package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkDownUtilsTest {

    MarkDownUtils markDownUtils = new MarkDownUtils();
    @Test
    void markdownToHtml() {
        String table = "| hello | hi   | 哈哈哈   |\n" +
                "| ----- | ---- | ----- |\n" +
                "| 斯维尔多  | 士大夫  | f啊    |\n" +
                "| 阿什顿发  | 非固定杆 | 撒阿什顿发 |\n" +
                "\n";
        String a = "[imCoding 爱编程](http://www.dushao.cn)";
        System.out.println(markDownUtils.markdownToHtml(a));
    }

    @Test
    void markdownToHtmlExtensions() {
        String table = "| hello | hi   | 哈哈哈   |\n" +
                "| ----- | ---- | ----- |\n" +
                "| 斯维尔多  | 士大夫  | f啊    |\n" +
                "| 阿什顿发  | 非固定杆 | 撒阿什顿发 |\n" +
                "\n";
        String a = "[imCoding 爱编程](http://www.dushao.cn)";
        System.out.println(markDownUtils.markdownToHtmlExtensions(a));
    }
}