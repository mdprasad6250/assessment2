package com.za.ps.assess2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Durga on 25/05/2020.
 */
public class assess2 {
    public static void main(String args[]){
        Map<String, List<InputModel>> betInput = new HashMap<String, List<InputModel>>();
        String participent;
        try{
            File file = new File("C:\\Users\\dp1\\Desktop\\assess\\Playsafeassessment\\src\\main\\java\\com\\za\\ps\\assess2\\inputfile.txt");
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            while((participent=br.readLine())!=null)
            {
                betInput.put(participent,null);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        List<InputModel> betList = null;
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        StringTokenizer stringTokenizer = null;
        InputModel inputModel = null;
        String player = null;
        while(!"Deal".equalsIgnoreCase(inputValue)){
            stringTokenizer = new StringTokenizer(inputValue," ");
            if(stringTokenizer.hasMoreTokens()) {
                player = stringTokenizer.nextToken();
                betList = betInput.get(player);
                if(betList==null){
                    betList = new ArrayList<InputModel>();
                }
                if(stringTokenizer.hasMoreTokens()){
                    inputModel = new InputModel();
                    inputModel.setChoice(stringTokenizer.nextToken());
                    if(stringTokenizer.hasMoreTokens()){
                        inputModel.setBet(Float.valueOf(stringTokenizer.nextToken()));
                    }else{
                        //Invalid input
                    }
                }else{
                    //Invalid input
                }
                betList.add(inputModel);
            }else{
                //Invalid Input
            }
            betInput.put(player,betList);
            inputValue = scanner.nextLine();
        }

        //Random Value
        int min = 1;
        int max = 36;
        int diceValue = (int) (Math.random() * (max - min + 1) + min);
        System.out.println("Number:"+diceValue);

        //Results evalution
        System.out.println("Player    Bet Outcome Winnings");
        for (Map.Entry<String, List<InputModel>> entry : betInput.entrySet()) {
            betList = entry.getValue();
            if(betList!=null){
                System.out.print(getPrintString(entry.getKey(),15));
                for(int i=0;i<betList.size();i++){
                    inputModel = betList.get(i);
                    System.out.print(inputModel.getChoice()+"\t");

                    if(inputModel.getChoice().equalsIgnoreCase("EVEN")){
                        if(diceValue%2==0){
                            System.out.print("WIN\t"+(inputModel.getBet()*2));
                        }else{
                            System.out.print("LOSE\t0.0");
                        }
                    }else if(inputModel.getChoice().equalsIgnoreCase("ODD")){
                        if(diceValue%2!=0){
                            System.out.print("WIN\t"+(inputModel.getBet()*2));
                        }else{
                            System.out.print("LOSE\t0.0");
                        }
                    }else {
                        try{
                            if(diceValue==Float.valueOf(inputModel.getChoice())){
                                System.out.print("WIN\t"+(inputModel.getBet()*36));
                            }else{
                                System.out.print("LOSE\t0.0");
                            }
                        }catch (NumberFormatException nfe){
                            System.out.print("LOSE\t0.0");
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    private static String getPrintString(String name, int size) {
        for(int i=0;i<(size - name.length());i++){
            name = name + " ";
        }
        return name;
    }
}