/*
 * ObjectInspectorJFrame.java
 *
 * Created on May 24, 2007, 3:10 AM
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * Copyright (C) 2007 Cheok YanCheng <yccheok@yahoo.com>
 */

package configuradorpaf.view;

import com.l2fprod.common.propertysheet.*;

import java.beans.*;

import java.awt.*;

/**
 *
 * @author  yccheok
 */
public class ObjectInspectorJFrame extends javax.swing.JFrame {
    
    /** Creates new form ObjectInspectorJFrame */
    public ObjectInspectorJFrame(Object bean) {
        initComponents();
        
        this.sheet = this.createPropertySheetPanel(bean);
        
        this.setTitle("Properties of " + this.sheet.getBean().getClass().getName());
        this.getContentPane().add(this.sheet, BorderLayout.CENTER);        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-265)/2, (screenSize.height-317)/2, 265, 317);
    }// </editor-fold>//GEN-END:initComponents

    private static class PropertyEditorRegistryEx extends PropertyEditorRegistry {
        // We will try to get the "nearest" super class.        
        public synchronized PropertyEditor getEditor(Class type) {
            PropertyEditor editor = super.getEditor(type);

            Class c = type;
        
            while(editor == null) {
                c = c.getSuperclass();

                if(c == null)
                    return editor;

                editor = super.getEditor(c);
            }

            return editor;
        }
    }
        
    private ObjectInspectorJPanel createPropertySheetPanel(Object bean) {    
        return new ObjectInspectorJPanel(bean);
    }
    
    public void setBean(Object bean) {
        sheet.setBean(bean);
        this.setTitle("Properties of " + this.sheet.getBean().getClass().getName());
    }
    
    private final ObjectInspectorJPanel sheet;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
