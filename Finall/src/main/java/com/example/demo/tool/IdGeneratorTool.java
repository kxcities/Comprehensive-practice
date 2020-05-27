package com.example.demo.tool;
public class IdGeneratorTool {
	private static long ID_COUNT = 0L;
	public static String IdGenerate() {
		return String.valueOf(ID_COUNT + 1);
	}
	public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(IdGenerate());
        }
    }
}
