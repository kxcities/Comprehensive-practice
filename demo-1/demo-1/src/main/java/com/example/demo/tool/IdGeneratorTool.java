package com.example.demo.tool;

import java.util.UUID;

public class IdGeneratorTool {
	public static String goodsIdGenerate() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static String dealIdGenerate() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static String commentIdGenerate() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(goodsIdGenerate());
        }
    }
}
