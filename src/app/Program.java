package app;

import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Lesson> list = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso? ");
        int n = sc.nextInt();
        for (int i=0; i<n; i++){
            System.out.println("Dados da "+ i + "a aula: ");
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Título: ");
            sc.nextLine();
            String title = sc.nextLine();
            if(ch == 'c'){
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int duration = sc.nextInt();

                list.add(new Video(title, url, duration));
            }
            else {
                System.out.print("Descrição: ");
                String descri = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int quantity = sc.nextInt();

                list.add(new Task(title, descri, quantity));
            }
        }
        System.out.println();

        int sum = 0;
        for (Lesson les: list) {
            int d = les.duration();
            sum += d;
        }
        System.out.println("DURAÇÃO TOTAL DO CURSO = "+ sum + " segundos");

        sc.close();
    }
}
