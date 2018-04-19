/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.JFrameUpdate;
import javax.swing.WindowConstants;

/**
 *
 * @author tguyot
 */
public class CtrlUpdate {
    private CtrlPrincipal ctrlPrin;
    JFrameUpdate vue = new JFrameUpdate();
    public CtrlUpdate(CtrlPrincipal ctrlPrin) {
        this.ctrlPrin = ctrlPrin;
        vue.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    public JFrameUpdate getVue(){
        return vue;
    }
}
