package com.example.shop.demo;

import com.example.shop.demo.textEditor.TextEditor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TextEditorTest {

    @Test
    public void test1(){

        TextEditor textEditor = new TextEditor();
        textEditor.addText("leetcode");

        int k = textEditor.deleteText(4);
        assertEquals(4, k);

        textEditor.addText("practice");

        String s = textEditor.cursorRight(3);
        assertEquals("etpractice", s);

        s = textEditor.cursorLeft(8);
        assertEquals("leet", s);

        k = textEditor.deleteText(10);
        assertEquals(4, k);

        s = textEditor.cursorLeft(2);
        assertEquals("", s);

        s = textEditor.cursorRight(6);
        assertEquals("practi", s);
    }
}
