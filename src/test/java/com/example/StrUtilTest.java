package com.example;

import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Hutool StrUtil 常用方法单元测试
 */
public class StrUtilTest {

    /* ---------- 判空系列 ---------- */

    @Test
    public void testIsBlank() {
        // 对于 null、""、以及仅包含空白字符的字符串都返回 true
        assertTrue(StrUtil.isBlank(null));
        assertTrue(StrUtil.isBlank(""));
        assertTrue(StrUtil.isBlank("   "));
        assertTrue(StrUtil.isBlank("\t\n"));
        // 其他情况返回 false
        assertFalse(StrUtil.isBlank("a"));
        assertFalse(StrUtil.isBlank("  a  "));
    }

    @Test
    public void testIsEmpty() {
        // 仅对 null 和 "" 返回 true
        assertTrue(StrUtil.isEmpty(null));
        assertTrue(StrUtil.isEmpty(""));
        // 包含任意字符（含空格）都返回 false
        assertFalse(StrUtil.isEmpty(" "));
        assertFalse(StrUtil.isEmpty("\t"));
        assertFalse(StrUtil.isEmpty("a"));
    }

    @Test
    public void testIsNotBlank() {
        // 与 isBlank 相反
        assertFalse(StrUtil.isNotBlank(null));
        assertFalse(StrUtil.isNotBlank("  "));
        assertTrue(StrUtil.isNotBlank("x"));
        assertTrue(StrUtil.isNotBlank("  x  "));
    }

    @Test
    public void testIsNotEmpty() {
        // 与 isEmpty 相反
        assertFalse(StrUtil.isNotEmpty(null));
        assertFalse(StrUtil.isNotEmpty(""));
        assertTrue(StrUtil.isNotEmpty(" "));
        assertTrue(StrUtil.isNotEmpty("a"));
    }

    /* ---------- 其他高频方法 ---------- */

    @Test
    public void testHasBlank() {
        // 任意一个参数为 blank 即返回 true
        assertTrue(StrUtil.hasBlank("a", "b", null));
        assertTrue(StrUtil.hasBlank("a", "", "c"));
        assertFalse(StrUtil.hasBlank("a", "b", "c"));
    }

    @Test
    public void testJoin() {
        // 用指定分隔符拼接
        assertEquals("a,b,c", StrUtil.join(",", "a", "b", "c"));
        // 跳过 null 元素
        //assertEquals("a,c", StrUtil.join(",", "a", null, "c"));
        System.out.println(StrUtil.join(",", "a", null, "c"));
    }

    @Test
    public void testFormat() {
        // 类似 SLF4J 的占位符风格
        assertEquals("Hello Java", StrUtil.format("Hello {}", "Java"));
        assertEquals("1 + 1 = 2", StrUtil.format("{} + {} = {}", 1, 1, 2));
    }
}
