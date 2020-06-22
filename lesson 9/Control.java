/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

//Самуйлов А.В.
public class Control {
    public double pointaX;
    public double pointaY;
    public double pointpX;
    public double pointpY;
    public double AllMass;
    public double AllPehMass;
    rect [] shapes;
    
    public Control(rect [] shapes){
        this.shapes=shapes;
    }
    //Геттеры
    //Установка новой координаты X центра масс всех юниов
    public double getAllnewX(){
        AllMass=0;
        for (int i=0;i<shapes.length;++i){
            pointaX+= shapes[i].getXpointC()*shapes[i].getAllMass();
            AllMass+= shapes[i].getAllMass();   
        }
        pointaX= pointaX/AllMass;
        System.out.println(pointaX);
        return pointaX;
    }
    //Установка новой координаты Y центра масс всех юниов
    public double getAllnewY(){
        AllMass=0;
        for (int i=0;i<shapes.length;++i){
            pointaY+=shapes[i].getYpointC()*shapes[i].getAllMass();
            AllMass+=shapes[i].getAllMass();   
        }
        pointaY= pointaY/AllMass;
        System.out.println(pointaY);
        return pointaY;
        
    }
    //Установка новой координаты X центра масс всей пехоты
    public double getPehnewX(){
        AllPehMass=0;
        for (int i=0;i<shapes.length;++i) {
            pointpX += shapes[i].getXpointC() * shapes[i].getPehhMass();
            AllPehMass += shapes[i].getPehhMass();   
        }
        pointpX=pointpX/AllPehMass;
        System.out.println(pointpX);
        return pointpX;
    }
    //Установка новой координаты Y центра масс всей пехоты
    public double getPehnewY(){
        AllPehMass=0;
        for (int i=0;i<shapes.length;++i) {
            pointpY += shapes[i].getYpointC() * shapes[i].getPehhMass();
            AllPehMass += shapes[i].getPehhMass();   
        }
        pointpY=pointpY/AllPehMass;
        System.out.println(pointpY);
        return pointpY;
    }
    
}
