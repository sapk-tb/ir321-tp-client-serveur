/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agirar01
 */
class Shell {

    static String execute(String message) {
        try {
            switch (message.trim().split(" ")[0]) {
                case "1":
                case "ADD":
                    Integer a = Integer.parseInt(message.trim().split(" ")[1]);
                    Integer b = Integer.parseInt(message.trim().split(" ")[2]);
                    return ("" + (a + b));
                case "2":
                case "MUL":
                    Integer c = Integer.parseInt(message.trim().split(" ")[1]);
                    Integer d = Integer.parseInt(message.trim().split(" ")[2]);
                    return ("" + (c * d));
                case "3":
                case "DIV":
                    Integer e = Integer.parseInt(message.trim().split(" ")[1]);
                    Integer f = Integer.parseInt(message.trim().split(" ")[2]);
                    if(f == 0){
                        throw new Exception("Division by zero");
                    }
                    return ("" + ((double) e / (double) f));
                default:
                    return "exception : command not found ! (" + message.trim().split(" ")[0] + ") ";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "exception : " + ex.toString();
        }
    }

}
