package com.poly.demo.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.poly.demo.bean.Student;

public class StreamAPI {

    static List<Student> list = Arrays.asList(
            new Student("Nguyễn Văn Tèo", true, 7.5),
            new Student("Trần Thị Thu Hương", false, 5.5),
            new Student("Phạm Đức Cường", true, 9.5),
            new Student("Lê Thị Mỹ Hồng", false, 6.5),
            new Student("Đoàn Thị Kim Ty", false, 8.0));

    public static void main(String[] args) {
        demo4();
    }

    private static void demo1() {
        Stream<Integer> stream1 = Stream.of(1, 9, 4, 7, 5, 2);
        stream1.forEach(n -> {
            System.out.println(n);
        });

        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        list.stream().forEach(n -> {
            System.out.println(n);
        });
        
    }

    private static void demo2() {
        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        List<Double> result = list.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> Math.sqrt(n))
                .peek(d -> System.out.println(d))
                .collect(Collectors.toList());
    }

    public static void demo3() {
        List<Student> result = list.stream()
                .filter(sv -> sv.getMarks() >= 7)
                .peek(sv -> sv.setName(sv.getName().toUpperCase()))
                .collect(Collectors.toList());

        result.forEach(sv -> {
            System.out.println(">> Name: " + sv.getName());
            System.out.println(">> Marks: " + sv.getMarks());
            System.out.println();
        });
    }

    public static void demo4() {
        // Tinh diem trung binh
        double average = list.stream().mapToDouble(sv -> sv.getMarks()).average().getAsDouble();
        System.out.println("average: " + average);

        // Tinh tong diem
        double sum = list.stream().mapToDouble(sv -> sv.getMarks()).sum();
        System.out.println("sum: " + sum);

        // Tim diem thap nhat
        double min_marks = list.stream().mapToDouble(sv -> sv.getMarks()).min().getAsDouble();
        System.out.println("min_marks: " + min_marks);

        // Kiem tra tat ca sv co pass khong
        boolean all_passes = list.stream().allMatch(sv -> sv.getMarks() >= 5);
        System.out.println("all_passes: " + all_passes);

        // Tim ten sinh vien co diem thap nhat
        Student min_sv = list.stream().reduce(list.get(0), (min, sv) -> sv.getMarks() < min.getMarks() ? sv : min);

        // Student min_sv = list.get(0);
        // for (Student sv : list) {
        // if (sv.getMarks() < min_sv.getMarks()) {
        // min_sv = sv;
        // }
        // }
        System.out.println("min_sv: " + min_sv.getName());
    }

}
