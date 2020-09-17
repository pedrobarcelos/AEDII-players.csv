import java.io.*;
import java.io.Reader;
import java.time.Year;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.Scanner;

public class Jogador {
        //atributes
        private int id;
        private String name;
        private int height;
        private int width;
        private String college;
        private int BirthYear;
        private String birthCity;
        private String birthState;
        public String LINE;
        private Scanner s;
        //constructors
        public Jogador(){};
        public Jogador(String name){this.name = name;}
        //gets sets (etc)
        public int getId(){
            return this.id;
        }
        public void setId(int id){
            this.id = id;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public void setHeight(int height){
            this.height = height;
        }
        public int getHeight(){
            return this.height;
        }
        public void setWidth(int width){
            this.width = width;
        }
        public int getWidth(){
            return this.width;
        }
        public void setCollege(String College){
            this.college = College;
        }
        public String getCollege(){
            return this.college;
        }
        public void setBirthYear(int BirthYear){
            this.BirthYear = BirthYear;
        }
        public int getBirthYear(){
            return this.BirthYear;
        }
        public void setbirthCity(String birthCity){
            this.birthCity = birthCity;
        }
        public String getbirthCity(){
            return this.birthCity;
        }
        public void setbirthState(String birthState){
            this.birthState = birthState;
        }
        public String getbirthState(){
            return this.birthState;
        }
        //methods read, print and clone
        public Jogador clone(){
            Jogador J2 = new Jogador();
            return J2;
        }
        public void printt(){
            MyIO.println("["+getId()+" ## "+getName()+" ## " +getHeight()+" ## " + getWidth()+" ## "+getBirthYear()+" ## "+getCollege()+" ## "+getbirthCity()+" ## "+getbirthState()+"]");
        }

        //method isFim()
        public static boolean isFim(String line){
            return (line.charAt(0)=='F' && line.charAt(1)=='I'&& line.charAt(2)=='M') ?  true : false;
        }
        public static int findIndex(char n){
            int index = 0;
            if(n=='1')index = 1;
            if(n=='2')index = 2;
            if(n=='3')index = 3;
            if(n=='4')index = 4;
            if(n=='5')index = 5;
            if(n=='6')index = 6;
            if(n=='7')index = 7;
            if(n=='8')index = 8;
            if(n=='9')index = 9;
            return index;
        }
        public static int findId(String str){
            int id = 0;
            int contagem = 0;
            char[] numeros = {0,0,0,0,0,0,0,0}; 
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == ','){
                    i = str.length();
                }else {
                    numeros[i] = str.charAt(i);
                    contagem+=1;
                }
            }
            if(contagem == 1){
                id = findIndex(numeros[0]);
            }
            if(contagem == 2){
                id = (findIndex(numeros[0])*10) + (findIndex(numeros[1]));
            }
            if(contagem == 3){
                id = (findIndex(numeros[0])*100) + (findIndex(numeros[1])*10) + (findIndex(numeros[2]));
            }
            if(contagem == 4){
                id = (findIndex(numeros[0])*1000) + (findIndex(numeros[1])*100) + (findIndex(numeros[2])*10) + (findIndex(numeros[3]));   
            }
            return id;
        }
        public static int transform(char[] numbers, String str){
            int index = 0;
            if(str.length() == 1){
                index = findIndex(numbers[0]);
            }
            if(str.length() == 2){
                index = (findIndex(numbers[0])*10) + (findIndex(numbers[1]));
            }
            if(str.length() == 3){
                index = (findIndex(numbers[0])*100) + (findIndex(numbers[1])*10) + (findIndex(numbers[2]));
            }
            if(str.length() == 4){
                index = (findIndex(numbers[0])*1000) + (findIndex(numbers[1])*100) + (findIndex(numbers[2])*10) + (findIndex(numbers[3]));   
            }
            return index;
        }
        public int registerId(String str, int virgula){
            int n = str.length();
            String id = "";
            virgula = 0;
            for (int i = 0; i < n; i++){
                if(!(str.charAt(i)==',')){
                    id += str.charAt(i);
                }else{
                    virgula = i;
                    i = n+1;
                }
            }
            char[] numbers = {0,0,0,0};
            for(int i = 0; i < id.length(); i++){
                numbers[i]=id.charAt(i);
            }
            int id2 = transform(numbers, id);
            setId(id2);
            return virgula;
        }
        public int registerName(String str, int virgula){
            String name = "";
            int n = str.length();
            for(int i=virgula+1; i < n; i++){
                if(!(str.charAt(i)==',')){
                    name += str.charAt(i);
                }else{
                    virgula = i;
                    i = n+1;
                }
            }
            setName(name);
            return virgula;
        }
        public int registerHeigth(String str, int virgula){
            String height = "";
            int n = str.length();
            for (int i = virgula+1; i < n; i++){
                if(!(str.charAt(i)==',')){
                    height += str.charAt(i);

                }else{
                    virgula = i;
                    i = n+1;
                }
            }
            char[] numbers2 = {0,0,0};
            for(int i = 0; i < height.length(); i++){
                numbers2[i]=height.charAt(i);
            }
            int height2 = transform(numbers2,height);
            setHeight(height2);
            return virgula;
        }
        public int registerWidth(String str, int virgula){
            String width = "";
            int n = str.length();
            for (int i = virgula+1; i < n; i++){
                if(!(str.charAt(i)==',')){
                    width += str.charAt(i);
                }else{
                    virgula = i;
                    i = n+1;
                }
            }
            char[] numbers3 = {0,0,0};
            for(int i = 0; i < width.length(); i++){
                numbers3[i]=width.charAt(i);
            }
            int width2 = transform(numbers3, width);
            setWidth(width2);
            return virgula;
        }
        public int registerCollege(String str, int virgula){
            String college = "";
            int n = str.length();
            for (int i = virgula+1; i < n; i++){
                if(!(str.charAt(i)==',')){
                    college += str.charAt(i);

                }else if(str.charAt(i)==',' && i == (virgula+1)){
                        college = "nao informado";
                        i = n;
                        virgula +=1;
                } else{
                    virgula = i;
                    i = n+1;
                }
            }
            setCollege(college);
            return virgula;
        }
        public int registerBirthYear(String str, int virgula){
            String YEAR = "";
            int n = str.length();
            for (int i = virgula+1; i < n; i++){
                if(!(str.charAt(i)==',')){
                    YEAR += str.charAt(i);

                }else if(str.charAt(i)==',' && i == virgula+1){
                        YEAR = "nao informado";
                        i = n;
                        virgula = i;
                } else{
                    virgula = i;
                    i = n+1;
                }
            }
            char[] year = {0,0,0,0};
            for(int i = 0; i < YEAR.length(); i++){
                year[i]=YEAR.charAt(i);
            }
            int birthYear = transform(year, YEAR);
            setBirthYear(birthYear);
            return virgula;
        }
        public int registerBirthCity(String str, int virgula){
            String city = "";
            int n = str.length();
            for (int i = virgula+1; i < n; i++){
                if(!(str.charAt(i)==',')){
                    city += str.charAt(i);

                }else if(str.charAt(i)==',' && i == virgula+1){
                        city = "nao informado";
                        i = n;
                        virgula = i;
                } else{
                    virgula = i;
                    i = n+1;
                }
            }
            setbirthCity(city);
            return virgula;
        }
        public void registerState(String str, int virgula){
            String state = "";
            int n = str.length();
            n = str.length();
            for(int i = virgula; i < n;i++){
                if(i<n-1)state += str.charAt(i+1);
            }
            if(virgula > n){
                state="nao informado";
            }
            setbirthState(state);
        }
        public void read(String str){
            int n = str.length();
            int virgula = 0;
            //ID
            virgula = registerId(str, virgula);
            //NAME
            virgula = registerName(str, virgula);
            //ALTURA
            virgula = registerHeigth(str,virgula);
            //PESO
            virgula = registerWidth(str, virgula);
            //FACULDADE
            virgula = registerCollege(str, virgula);
            //ANO DE NASCIMENTO
            virgula = registerBirthYear(str, virgula);
            //CIDADE
            virgula = registerBirthCity(str, virgula);
            //ESTADO 
            registerState(str, virgula);
    }

    public static void main(String[] args) throws Exception {
        Jogador[] players = new Jogador[4000]; //Declaracao do vetor de Playes
        BufferedReader reader = new BufferedReader(new FileReader("players.csv")); //abrir o arquivo no modo leitura
        reader.readLine();
        int i = 0;
        String line = "";
        while((line = reader.readLine()) != null){ //repetir ate o fim do arquivo
            players[i] = new Jogador();
            players[i].read(line);
            i++;
        }
        reader.close();
        String str = MyIO.readLine();
        i = 0;
        while(!isFim(str)){
            int id = findId(str);
            for(i = 0; i < 4000; i++){
                if(players[i].getId() == id){
                    players[i].printt();
                    i = 4000;
                }
            }     
            str = MyIO.readLine();
        }
    }
}
