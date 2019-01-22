/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import helperclasses.ReadFile;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author Turnyur Siy Williams
 */
public class AdvanceCalculatorController extends VBox implements Initializable {
    @FXML
    private Main application;

    @FXML
    private VBox calcVBox;

    @FXML
    private TextField txtDisplay;
    @FXML
    private Button btnFive;
    @FXML
    private Button btnTwo;
    @FXML
    private Button btnNine;
    @FXML
    private Button btnOne;
    @FXML
    private Button btnThree;
    @FXML
    private Button btnFour;
    @FXML
    private Button btnEight;
    @FXML
    private Button btnSeven;
    @FXML
    private Button btnSix;
    @FXML
    private Button btnDot;
    @FXML
    private Button btnZero;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnDiv;
    @FXML
    private Button btnMul;
    @FXML
    private Button btnSub;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEqual;
    
    

    @FXML
    private Button btnRoot;
    @FXML
    private Button btnSquare;
    @FXML
    private Button btnSin;
    @FXML
    private Button btnCos;
    @FXML
    private Button btnTan;
    @FXML
    private Button btnLog;
    @FXML
    private Button btnHex;
    @FXML
    private Button btnBin;
    @FXML
    private Button btnPi;
    @FXML
    private Button btnAsin;
    @FXML
    private Button btnAcos;
    @FXML
    private Button btnAtan;
    @FXML
    private Button btnNLog;
    @FXML
    private Button btnExp;
    @FXML
    private static TextArea txtArea_about_me;
    
          
          
  public AdvanceCalculatorController(){
       btnOne =new Button();
       txtDisplay=new TextField();
       btnTwo =new Button();
       btnThree =new Button();
       btnFour =new Button();
       btnFive =new Button();
       btnSix =new Button();
       btnSeven =new Button();
       btnEight =new Button();
       btnNine =new Button();
       btnDot=new Button();
       btnZero=new Button();
       calcVBox=new VBox();
       
          
      btnRoot = new Button();
      btnSquare = new Button();
      btnSin = new Button();
      btnCos = new Button();
      btnTan = new Button();
      btnLog = new Button();
      btnHex = new Button();
      btnBin = new Button();
      btnPi = new Button();
      btnAsin = new Button();
      btnAcos = new Button();
      btnAtan = new Button();
      btnNLog = new Button();
      btnExp = new Button();
      txtArea_about_me=new TextArea();
   }
  public void setApp(Main application){
        this.application = application;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       
    }   
    @FXML
     private void handleGeneralAction(ActionEvent event) {
         
         clearScreen();
        checkEventSource(event);
         
        deactivateFlag();
    }
    @FXML
     private void  handleClearButton(ActionEvent event) {
         if(txtDisplay.getText().equals("")){
             txtDisplay.setText("");
         }else{
             initiateFade(50,6);
             txtDisplay.setText("");
         }
        
     }

    private void initiateFade(int duration,int countCycle) {
        //        String showDisplay= txtDisplay.getText()+btnOne.getText();
        FadeTransition ft = new FadeTransition(Duration.millis(50), txtDisplay);
        ft.setFromValue(1.0);
        ft.setToValue(0.6);
        ft.setCycleCount(countCycle);
        ft.setAutoReverse(true);
        
        ft.play();
    }
    @FXML
     private void  handleNumberOperator(ActionEvent event) {
          if(txtDisplay.getText()==""){
              initiateFade(20,2);
          } 
            checkNumberOperator(event);
        
     } 
     @FXML
     private void handleDelete(){
        TranslateTransition tt = new TranslateTransition(Duration.millis(200), calcVBox);
         tt.setByY(200f);
         tt.setCycleCount(2);
         tt.setAutoReverse(true);

         tt.play(); 
     }
     @FXML
     private void handleClose(){
        TranslateTransition tt = new TranslateTransition(Duration.millis(200), calcVBox);
         tt.setByY(200f);
         tt.setCycleCount(2);
         tt.setAutoReverse(true);

         tt.play(); 
     }
     @FXML
     private void handleAboutUs(ActionEvent event) throws Exception{
//              TranslateTransition tt = new TranslateTransition(Duration.millis(200), calcVBox);
//         tt.setByY(200f);
//         tt.setCycleCount(2);
//         tt.setAutoReverse(true);
//
//         tt.play();
//         Duration.millis(1000);
//         TranslateTransition tt = new TranslateTransition(Duration.millis(200), calcVBox);
//         tt.setByY(200f);
//         tt.setCycleCount(2);
//         tt.setAutoReverse(true);

      //   tt.play();
         //  Main.gotoAboutUs(event);
          Main.replaceSceneContent("AdvanceCalculator.fxml","AdvanceCalculator.css");
        
              // getLocaleText();
     }
      @FXML
     private void handleButtonBack() throws Exception{
         
            Main.replaceSceneContent("AbousUs.fxml","AboutUs.css");
            
     }
     public  void getLocaleText() throws IOException {
        ReadFile aboutTSoftware =new ReadFile();
        String about_me=aboutTSoftware.OpenFile(
                "C:/Users/Turnyur Siy/Documents/NetBeansProjects/AdvanceCalculator/src/helperclasses/aboutTSoftware.txt");
        txtDisplay.setText(about_me);
        System.out.println(about_me);
    }
    private void checkNumberOperator(ActionEvent event) {
        if(event.getSource()==btnDiv){
            btnDivAction();
        }else if(event.getSource()==btnMul){
            btnMulAction();
        }else if(event.getSource()==btnSub){
            btnSubAction();
        }
        else if(event.getSource()==btnAdd){
            btnAddAction();
        }
    } 
     @FXML
     private void  handleEqualButton(ActionEvent event) {
       
         getLastOperand();
         txtDisplay.setText(getLastOperand().toString());
        //Duration.millis(1000);
         TranslateTransition tt = new TranslateTransition(Duration.millis(50), txtDisplay);
         tt.setByY(-110f);
         tt.setCycleCount(4);
         tt.setAutoReverse(true);

         tt.play();
         setFlag();
     }  
    private Double getLastOperand() throws NumberFormatException {
        Double result=0.0;
        try{
            if(  txtDisplay.getText()!=""){
            
            String showDisplay= txtDisplay.getText() ;
            if(totalFirst.equals(0.0) );
            String testing=showDisplay.
                    substring(showDisplay.indexOf(mathOperator  )/*,
                    //                     ((totalFirst.toString().length()-1)+(mathOperator+1) )*/ );
            char[] ret_testing=new char[testing.length()];
            String totalLast_string="";
            for(int i=1;i<testing.length();i++){
                ret_testing[i]= testing.charAt(i);
                totalLast_string+=ret_testing[i];
            }
            
            totalLast=Double.parseDouble(totalLast_string);
             result = check_mathOperator(result); 
        }
        }catch(NumberFormatException e){
           
              initiateFade(15,8);
          
        }
        return result;
    }
    private  void checkEventSource(ActionEvent event) {
        if(event.getSource()==btnOne){
            btnOneAction();
        }else if(event.getSource()==btnTwo){
            btnTwoAction();
        }else if(event.getSource()==btnThree){
            btnThreeAction();
        }
        else if(event.getSource()==btnFour){
            btnFourAction();
        }else if(event.getSource()==btnFive){
            btnFiveAction();
        }else if(event.getSource()==btnSix){
            btnSixAction();
        }else if(event.getSource()==btnSeven){
            btnSevenAction();
        }else if(event.getSource()==btnEight){
            btnEightAction();
        }else if(event.getSource()==btnNine){
            btnNineAction();
        }else if(event.getSource()==btnDot){
            btnDotAction();
        }else if(event.getSource()==btnZero){
            btnZeroAction();
        }
        else if(event.getSource()==btnRoot){
            btnRootAction();
        }else if(event.getSource()==btnSquare){
            btnSquareAction();
        }else if(event.getSource()==btnSin){
            btnSinAction();
        }else if(event.getSource()==btnCos){
            btnCosAction();
        }else if(event.getSource()==btnTan){
            btnTanAction();
        }else if(event.getSource()==btnLog){
            btnLogAction();
        }else if(event.getSource()==btnBin){
            btnBinAction();
        }else if(event.getSource()==btnHex){
            btnHexAction();
        }else if(event.getSource()==btnPi){
            btnPiAction();
        }else if(event.getSource()==btnAsin){
            btnAsinAction();
        }else if(event.getSource()==btnAcos){
            btnAcosAction();
        }else if(event.getSource()==btnAtan){
            btnAtanAction();
        }else if(event.getSource()==btnNLog){
            btnNLogAction();
        }else if(event.getSource()==btnExp){
            btnExpAction();
        }
        
        
        
        
        
        
        
    }

    private void btnRootAction() throws NumberFormatException {
        temp_total= Math.sqrt(Double.parseDouble(txtDisplay.getText()));
        txtDisplay.setText(temp_total .toString());
    }
    private void btnSinAction() throws NumberFormatException {
        temp_total= Math.sin(Math.toRadians(Double.parseDouble(txtDisplay.getText())));
        txtDisplay.setText(temp_total .toString());
    }
    @FXML
    private void btnCosAction() throws NumberFormatException {
      temp_total= Math.cos(Math.toRadians(Double.parseDouble(txtDisplay.getText())));
        txtDisplay.setText(temp_total .toString());
    }
    private void btnTanAction() throws NumberFormatException {
        temp_total= Math.tan(Math.toRadians(Double.parseDouble(txtDisplay.getText())));
        txtDisplay.setText(temp_total .toString());
    }
    private void btnSquareAction() throws NumberFormatException {
        temp_total= Math.pow(Double.parseDouble(txtDisplay.getText()), 2);
        txtDisplay.setText(temp_total .toString());
    }
    private void btnBinAction() throws NumberFormatException {
        //Not implemented yet
    }
    private void btnHexAction() throws NumberFormatException {
        //Not implemented yet
        
    }
    private void btnPiAction() throws NumberFormatException {
        String showDisplay= txtDisplay.getText()+"3.142";
        txtDisplay.setText(showDisplay);
    }
    private void btnLogAction() throws NumberFormatException {
        temp_total= Math.log(Double.parseDouble(txtDisplay.getText()));
        txtDisplay.setText(temp_total .toString());
    }
    private void btnAsinAction() throws NumberFormatException {
        temp_total= Math.asin(Double.parseDouble(txtDisplay.getText()));
        txtDisplay.setText(temp_total .toString());
    }
    private void btnAcosAction() throws NumberFormatException {
        temp_total= Math.acos(Double.parseDouble(txtDisplay.getText()));
        txtDisplay.setText(temp_total .toString());
    }
    private void btnAtanAction() throws NumberFormatException {
        temp_total= Math.atan(Double.parseDouble(txtDisplay.getText()));
        txtDisplay.setText(temp_total .toString());
    }
    private void btnNLogAction() throws NumberFormatException {
        temp_total= Math.log10(Double.parseDouble(txtDisplay.getText()));
        txtDisplay.setText(temp_total .toString());
    }
    private void btnExpAction() throws NumberFormatException {
        temp_total= Math.exp(Double.parseDouble(txtDisplay.getText()));
        txtDisplay.setText(temp_total .toString());
    }
    
    
    
    private void btnOneAction() {
        String showDisplay= txtDisplay.getText()+btnOne.getText();
        txtDisplay.setText(showDisplay);
    }
    private void btnTwoAction() {
        String showDisplay= txtDisplay.getText()+btnTwo.getText();
        txtDisplay.setText(showDisplay);
    } 
    private void btnThreeAction() {
        String showDisplay= txtDisplay.getText()+btnThree.getText();
        txtDisplay.setText(showDisplay);
    } 
    private void btnFourAction() {
        String showDisplay= txtDisplay.getText()+btnFour.getText();
        txtDisplay.setText(showDisplay);
    }
    private void btnFiveAction() {
        String showDisplay= txtDisplay.getText()+btnFive.getText();
        txtDisplay.setText(showDisplay);
    }
    private void btnSixAction() {
        String showDisplay= txtDisplay.getText()+btnSix.getText();
        txtDisplay.setText(showDisplay);
    }
    private void btnSevenAction() {
        String showDisplay= txtDisplay.getText()+btnSeven.getText();
        txtDisplay.setText(showDisplay);
    } 
    private void btnEightAction() {
        String showDisplay= txtDisplay.getText()+btnEight.getText();
        txtDisplay.setText(showDisplay);
    }
    private void btnNineAction() {
        String showDisplay= txtDisplay.getText()+btnNine.getText();
        txtDisplay.setText(showDisplay);
    } 
    private void btnDotAction() {
        String showDisplay= txtDisplay.getText()+btnDot.getText();
        txtDisplay.setText(showDisplay);
    } 
    private void btnZeroAction() {
        String showDisplay= txtDisplay.getText()+btnZero.getText();
        txtDisplay.setText(showDisplay);
    }
    
    private void btnDivAction() {
        totalFirst= Double.parseDouble(txtDisplay.getText() );
        String showDisplay= txtDisplay.getText()+"/";
        txtDisplay.setText(showDisplay);
        getOperator('/' );
        deactivateFlag();
    }
    private void btnMulAction() {
         totalFirst= Double.parseDouble(txtDisplay.getText() );
        String showDisplay= txtDisplay.getText()+btnMul.getText();
        txtDisplay.setText(showDisplay);
        getOperator('x' );
        deactivateFlag();
    }
    private void btnSubAction() {
        totalFirst= Double.parseDouble(txtDisplay.getText() );
        String showDisplay= txtDisplay.getText()+btnSub.getText();
        txtDisplay.setText(showDisplay);
        getOperator('-' );
        deactivateFlag();
    }
    private void btnAddAction() {
        totalFirst= Double.parseDouble(txtDisplay.getText() );
        String showDisplay= txtDisplay.getText()+btnAdd.getText();
        txtDisplay.setText(showDisplay);
        getOperator('+' );
        deactivateFlag();
    }
    //Ported Codes From Previous Calculator -MyCalculator
    @FXML
    private static void getOperator(char txtDisplay ){
         mathOperator=txtDisplay ;
         
    }
    @FXML
   private static void setFlag(){
       flag=1;
   }
   @FXML
    private void clearScreen() {
        // TODO add your handling code here:
        if(flag==1)txtDisplay.setText("");
    }
   @FXML
   private static void deactivateFlag(){
       flag=0;
   }
   
   private Double check_mathOperator(Double result) {
        // String show=showDisplay. substring(mathOperator, showDisplay.length()-1);
        // totalLast=Double.parseDouble(show );
        
        switch(mathOperator){
            case '/':
                result =totalFirst/totalLast;
                break;
            case 'x':
                result =totalFirst*totalLast;
                break;
            case '-':
                result =totalFirst-totalLast;
                break;
            case '+':
                result =totalFirst+totalLast;
                break;
                
        }
        return result;
    }
   
           // Static Variables
    @FXML
   private static Double totalFirst=0.0;
    @FXML
   private static Double temp_total=0.0;
    @FXML
   private static Integer temp_total_int=0;
    @FXML
    private static Double totalLast=0.0;
    static Character mathOperator='N';
    static int flag;
    
}
