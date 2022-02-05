package com.aca.exam.exam1;

public class Exam {
    private int[] numbers;

    public Exam(int[] numbers){
        this.numbers = new int[numbers.length];
        for (int i = 0; i < numbers.length ; i++) {
            this.numbers[i] = numbers[i];
        }
    }

    public int getMax(){ //1. 5 թվերից առավելագույնը
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (max < numbers[i])
                max = numbers[i];
        }

        return max;
    }

    public int getMin(){ //2. 5 թվերից նվազագույնը
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (min > numbers[i])
                min = numbers[i];
        }

        return min;
    }

    public int[] numbersX2(){ // 3. 5 թվերից յուրաքանչյուրի արժեքի կրկնապատկում
//                          (այս քայլից հետո եթե օգտագործողը ընտրի օրինակ 1 մշակումը,
//                          ապա պետք է տեսնի նախկին առավելագույն արժեքի կրկնապատիկը)
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * 2;
        }
        return numbers;
    }

    public double getMid(){ //4. 5 թվերի միջինը
        double mid;
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
        sum += numbers[i];
        }
        mid = sum/numbers.length;
        return mid;
    }

    public void printNNum(int n){ //5. կպահանջի մուտքագրել N թիվ և կտպի N-րդ թիվը
//                                  (եթե N֊ը ունի անթույլատրելի արժեք, ապա կանտեսի N-րդ թվի տպելը)
        System.out.println(numbers[n-1]);
    }

    public int getDif(){ //6. 5 թվերից առավելագույնի և նվազագույնի տարբերությունը
        return getMax() - getMin();
    }

    public int zeros(){ //7. բոլոր 5 թվերում 0֊ների քանակը
        int zeros = 0;
        for (int i = 0; i < numbers.length; i++) {
            zeros += getZeros(numbers[i]);
        }
        return zeros;
    }

    private int getZeros(int n){
        int zeros = 0;
        if (n == 0)
            return 1;
        else {
            while (n / 10 != 0) {
                if (n % 10 == 0)
                    zeros++;
                n = n / 10;
            }
            return zeros;
        }
    }

    public void print(){
        for (int i = 0; i < numbers.length ; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("");
    }

}

/*
Ստեղծել ծրագիր, որը օգտագործողից կհարցնի 5 հատ թիվ,
այնուհետ կախված օգտագործողի ընտրած թվից՝ կիրականացնի համապատասխան մշակում և կտպի արդյունք։

8. ծրագրի ավարտ

Ծրագիրը օգտագործողից պետք է անվերջ հարցնի մշակման համար՝ քանի դեռ ծրագրի ավարտ նշանակող 8 թիվը չի մուտքագրվել։
Ծրագիրը պետք  է գրել Exam class֊ում,
 բոլոր փոփոխականները պետք է լինեն private,
  իսկ ծրագրի աշխատանքը պետք է սկել ExamTest class-ից։
*/