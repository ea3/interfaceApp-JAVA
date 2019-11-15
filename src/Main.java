import java.util.*;

public class Main {
    private static List<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("StormBringer", "Deep Purple");
        album.addSong("StormBringer", 4.6);
        album.addSong("Love don't mean a thing", 4.3);
        album.addSong("Holy man", 5.6);
        album.addSong("Hold on", 3.21);
        album.addSong("Lady double dealer", 6.23);
        album.addSong("You can't do it right", 4.25);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to Rock", "Ac/DC");
        album.addSong("For those about to rock", 2.6);
        album.addSong("I put the finger on you", 6.3);
        album.addSong("Let's go", 3.6);
        album.addSong("Venom", 2.21);
        album.addSong("Snowballed", 7.23);
        album.addSong("Evil walks", 3.25);
        album.addSong("C.O.D", 6.2);
        album.addSong("Breaking the Rules", 3.16);
        album.addSong("Breaking bad", 13.16);
        albums.add(album);

        List<Song> playlist = new Vector<>();
        albums.get(0).addToPlaylist("You can't do it right", playlist); //this one does actually play
        albums.get(0).addToPlaylist("Holy man", playlist);
        albums.get(0).addToPlaylist("Speed King", playlist); //does not exist
        albums.get(1).addToPlaylist(9, playlist);
        albums.get(1).addToPlaylist(8, playlist);
        albums.get(1).addToPlaylist(3, playlist);
        albums.get(1).addToPlaylist(97, playlist); //there is no track 97

        play(playlist);

        }

    private static void play(List<Song> playlist){ //changed to LIst
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size()==0){
            System.out.println("No songs in the playlist");
        }else{
            System.out.println("Now playing "+ listIterator.next().toString());
            printMenu();

        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println(" Playlist complete. ");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+ listIterator.next().toString());
                    }else{
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }

                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false ;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+ listIterator.previous().toString());
                    }else{
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }

                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+ listIterator.previous().toString());
                            forward = false;
                        }else{
                            System.out.println("We are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now playing "+ listIterator.next().toString());
                            forward = true;
                        }else{
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size() > 0 ){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;



            }


        }

    }


    private static void printMenu(){
        System.out.println("Available actions: \npress");
        System.out.println("0- to quit\n" +
                "1- to play next song\n" +
                "2- to play previous song\n" +
                "3- to replay current song \n" +
                "4- to list songs in the playlist\n" +
                "5- to print available actions\n" +
                "6- delete current song from  the playlist");
    }

    private static void printList(List<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("================================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=================================");
    }
































}
