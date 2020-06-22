
package practice_8;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
        
//Самуйлов А.В.
public class Practice_8 {
    public static Pair Score(int num,int temp,Team team1,Team team2){
        String t1=team1.getName();
        String t2=team2.getName();
        Random rndNum = new Random();
        int randomNum1 = rndNum.nextInt(11);
        int randomNum2 = rndNum.nextInt(11);
        int score1 = randomNum1+((randomNum1*temp)/100);
        int score2 = randomNum2+((randomNum2*temp)/100);
        //Начисляем очки победы,поражения,ничей обоим командам
        if (score1>score2){
            team1.setWin(team1.getWin()+1);
            team2.setLose(team2.getLose()+1);
        }
        else if (score1==score2){
            team1.setDraw(team1.getDraw()+1);
            team2.setDraw(team2.getDraw()+1);
            
        }
        else{
            team1.setLose(team1.getLose()+1);
            team2.setWin(team2.getWin()+1);
        }
        //Записываем забитые пропущенные мячи обоим командам
        //games.add(new Game(num,temp,team1.getName(),team2.getName(),score1,score2));
        team1.setGoals_scored(team1.getGoals_scored()+score1);
        team1.setGoals_received(team1.getGoals_received()+score2);
        team2.setGoals_scored(team2.getGoals_scored()+score2);
        team2.setGoals_received(team2.getGoals_received()+score1);
        //return score_result[];
        //games[num].setGoal_home(int goal_home);
        //games[num].setGoal_away(int goal_away);
        return new Pair(score1,score2);
        
    }
   
    public static void main(String[] args) {
        //Создание массива Команд
        Team [] teams = new Team[4];
        teams[0] = new Team("Team 1");
        teams[1] = new Team("Team 2");
        teams[2] = new Team("Team 3");
        teams[3] = new Team("Team 4");
        //Создание массива Игр
        ArrayList<Game> games = new  ArrayList();
        //счётчик холода,недель,температуры,игр
        int cold=0,week=0,htemp=0,num=0,atemp=0,maxTemp=0;
        //ВВОД
        Scanner sc = new Scanner(System.in);
        int input;
        //Цикл ВВОДА
        while (cold<3){
            input = sc.nextInt();
            if (input>=0){
            System.out.println("Играем!");
            cold=0;
            week+=1;
            num+=1;
            htemp+=input;
            //Проверяем температуру на максимум
            if(input>maxTemp){
                maxTemp=input;
            }
            //Выбираем 2 случайные команды из 4
            int kom1=0,kom2=0;
            Random rndTeam = new Random();
            while (kom1==kom2){
                kom1 = rndTeam.nextInt(4);
                kom2 = rndTeam.nextInt(4);
            }
            //int kom1 = rndTeam.nextInt(4);
            //int kom2 = rndTeam.nextInt(4);
           
            //
            Pair test = Score(num,input,teams[kom1],teams[kom2]);
            games.add(new Game(num,input,teams[kom1].getName(),teams[kom2].getName(),test.getFirst(),test.getSecond()));
        }
            else{
            cold=cold+1;
            week+=1;
            System.out.println("Слишком холодно для игры!");
            
        }  
        }
        //Выводим результаты команд
        for(int i=0;i<teams.length;i++){
            System.out.println(teams[i].getName()+"\n"+
                    "Wins:"+teams[i].getWin()+", Loses:"+teams[i].getLose()+", Ties"+teams[i].getDraw()+"\n"+
                    "Point Scored:"+teams[i].getGoals_scored()+", Point Allowed:"+teams[i].getGoals_received()+"\n");   
        }
        //Выводим результаты всех Игр
        for(int i=0;i<games.size();i++){
        System.out.println("Game #"+games.get(i).getNumber()+"\n"+
              "Temperature:"+games.get(i).getTemp()+"\n"+
              "Away Team:"+games.get(i).getAway()+","+games.get(i).getGoal_away()+"\n"+
              "Home Team:"+games.get(i).getHome()+","+games.get(i).getGoal_home()+"\n");
        }
        //Узнаем температуру
        atemp=htemp/week;
        
        System.out.println("Hottest Temp:"+maxTemp+"\n");
        System.out.println("Average Temp:"+atemp+"\n");
        }        
    }
    

