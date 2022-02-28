/*
 * Activity 3.7.2
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample extends ArrayList<String>
{  

     
    
   public static void main(String args[])
   {  
        ArrayListExample animalList = new ArrayListExample();
        Scanner sc = new Scanner(System.in);
        animalList.add("Dog");
        animalList.add("Cat");
        animalList.add("Rabbit");
        String input = "";
        Integer index;
        // isplaying elements
        System.out.println(animalList);
        
        

        while(true){

            System.out.println("Would you like to (a)dd, (i)nsert, (r)emove, re(p)lace, or (q)uit");
            input = sc.nextLine();

            if(input.equals("a")){

                System.out.println("Enter an animal: ");
                input = sc.nextLine();
                animalList.add(input);
            }else if(input.equals("i")){

                System.out.println("Enter an animal: ");
                input = sc.nextLine();
                while(true){
                    
                    try{
                        System.out.println("Enter a position:");
                        index = Integer.parseInt(sc.nextLine());
                        if(index > animalList.size()){
                            System.out.println("Please enter a valid integer.");
                        }else{
                            break;
                        }
                    } catch(Exception e){
                        System.out.println("Please enter an integer.");
                    }

                }
                animalList.add(index-1,input);
            }else if(input.equals("r")){

                while(true){
                    
                    try{
                        System.out.println("Enter a position:");
                        index = Integer.parseInt(sc.nextLine());
                        if(index > animalList.size()){
                            System.out.println("Please enter a valid integer.");
                        }else{
                            break;
                        }
                    } catch(Exception e){
                        System.out.println("Please enter an integer.");
                    }
                }
                animalList.remove(index-1);
            }else if(input.equals("p")){


                System.out.println("Enter an animal: ");
                input = sc.nextLine();
                while(true){
                    
                    try{
                        System.out.println("Enter a position:");
                        index = Integer.parseInt(sc.nextLine());
                        if(index > animalList.size()){
                            System.out.println("Please enter a valid integer.");
                        }else{
                            break;
                        }
                    } catch(Exception e){
                        System.out.println("Please enter an integer.");
                    }
                }
                animalList = replace(input,index-1,animalList);
            }else if(input.equals("q")){
                break;
            }else{
                System.out.println("Please enter a valid input.");
            }
            System.out.println(animalList);
        }

        
        // display elements
        System.out.println(animalList);
   }  

   public static ArrayListExample replace(String str, int index, ArrayListExample list){
        ArrayListExample tempArray = copyArray(list);
        ArrayListExample permArray = copyArray(list);
        permArray.add(index,str);
        if(index == permArray.size()){
            permArray.remove(permArray.size()-1);
        }else{
            permArray.removeRange(index + 1, permArray.size());
        }
        for(int i = index + 1; i < tempArray.size(); i++){
            permArray.add(tempArray.get(i));
        }
        return permArray;
   }

   public static ArrayListExample copyArray(ArrayListExample list){
    ArrayListExample copiedList = new ArrayListExample();
        for(int i = 0; i < list.size(); i++){
            copiedList.add(list.get(i));
        }
        return copiedList;
   }    
}