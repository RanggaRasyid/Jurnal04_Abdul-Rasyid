package com.company;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void pilihan(){
        System.out.println("Apa yang Ingin Kamu Lakukan");
        System.out.println(" 1. Input Lagu ");
        System.out.println(" 2. delete Lagu ");
        System.out.println(" 3. Putar Lagu ");
        System.out.println(" 4. Keluar ");
    }

    public static void main(String[] args) {
        LinkedList<PlayListLagu> playListLagus = new LinkedList<PlayListLagu>();
        Scanner input = new Scanner(System.in);
        boolean kondisi = true;

        while (kondisi){
            pilihan();
            switch (input.nextInt()){
                case 1 :
                    System.out.println(" Masukan Judul Lagu ");
                    String namaLagu = input.next();
                    String musisi = input.next();
                    playListLagus.addLast(new PlayListLagu(namaLagu,musisi));
                    break;
                case 2 :
                    System.out.println("1. delete lagu terakhir");
                    System.out.println("2. delete lagu berdasarkan judul");
                    int delete = input.nextInt();
                    if (delete == 1){
                        playListLagus.removeLast();
                    }else if ( delete == 2) {
                        String deleteJudul = input.next();
                        removeByTitle(playListLagus, deleteJudul);}
                    break;
                case 3 :
                    print(playListLagus);
                    break;
                case 4 :
                    break;
            }
        }
    }
    // mencetak head ke tail, dan tail ke head
    private static void print(LinkedList<PlayListLagu> playListLagus) {
        ListIterator<PlayListLagu>iterator = playListLagus.listIterator();
        while (iterator.hasNext()){
            if (iterator.hasPrevious()){
                System.out.print(", "+iterator.next());
            }
            else {
                System.out.print(iterator.next());
            }
        }
        iterator.previous();
        while (iterator.hasPrevious()){
            System.out.print(", "+ iterator.previous());
        }
        System.out.println();
    }
    // untuk mencari judul lagu yg diinput user
    public static void removeByTitle(LinkedList<PlayListLagu> playListLagus, String deleteJudul) {
        ListIterator<PlayListLagu> iterator = playListLagus.listIterator();
        while (iterator.hasNext()){
            PlayListLagu playListLagu = iterator.next();
            if (playListLagu.getNamaLagu().equalsIgnoreCase(deleteJudul)){
                iterator.remove();
            }
        }
    }
}