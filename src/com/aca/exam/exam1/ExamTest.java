package com.aca.exam.exam1;

import java.util.Scanner;

public class ExamTest {

    public static void main(String[] args) {

        int[] numbers = new int[5];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please insert 5 numbers: ");

        for (int i = 0; i < numbers.length ; i++) {
            numbers[i] = scanner.nextInt();
        }

        Exam functions = new Exam(numbers);

        System.out.println("Please insert number (from 1 to 8): ");
        int num = 0;
        num = scanner.nextInt();
        while (num != 8){

            if(num == 1)
                System.out.println(functions.getMax());
            if(num == 2)
                System.out.println(functions.getMin());
            if(num == 4)
                System.out.println(functions.getMid());
            if(num == 6)
                System.out.println(functions.getDif());
            if(num == 7)
                System.out.println(functions.zeros());
            if(num == 5){
                int N;
                System.out.print("Please enter N: ");
                N = scanner.nextInt();
                if(N > 0 && N <= numbers.length)
                    functions.printNNum(N);
            }
            if(num == 3){
                functions.numbersX2();
                functions.print();
            }

            System.out.println("Please insert number (from 1 to 8): ");
            num = scanner.nextInt();
        }


    }
}

/*
Ստեղծել ծրագիր, որը օգտագործողից կհարցնի 5 հատ թիվ,
այնուհետ կախված օգտագործողի ընտրած թվից՝ կիրականացնի համապատասխան մշակում և կտպի արդյունք։

1 5 թվերից առավելագույնը
2 5 թվերից նվազագույնը
3 5 թվերից յուրաքանչյուրի արժեքի կրկնապատկում (այս քայլից հետո եթե օգտագործողը ընտրի օրինակ 1 մշակումը, ապա պետք է տեսնի նախկին առավելագույն արժեքի կրկնապատիկը)
4 5 թվերի միջինը
5 կպահանջի մուտքագրել N թիվ և կտպի N-րդ թիվը (եթե N֊ը ունի անթույլատրելի արժեք, ապա կանտեսի N-րդ թվի տպելը)
6 5 թվերից առավելագույնի և նվազագույնի տարբերությունը
7 բոլոր 5 թվերում 0֊ների քանակը
8. ծրագրի ավարտ

Ծրագիրը օգտագործողից պետք է անվերջ հարցնի մշակման համար՝ քանի դեռ ծրագրի ավարտ նշանակող 8 թիվը չի մուտքագրվել։
Ծրագիրը պետք  է գրել Exam class֊ում,
 բոլոր փոփոխականները պետք է լինեն private,
  իսկ ծրագրի աշխատանքը պետք է սկել ExamTest class-ից։
*/