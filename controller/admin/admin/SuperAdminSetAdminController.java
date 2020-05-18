package controller.admin.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import datatypes.Admin;
import model.SuperAdminModel;
import view.AdminView;

public class SuperAdminSetAdminController implements ActionListener  {
	private AdminView view;
	private SuperAdminModel sAdModel;
	public SuperAdminSetAdminController(AdminView view, SuperAdminModel sAdModel) {
		this.view = view;
		this.sAdModel = sAdModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String fn = view.adminFirstNameField.getText();
		String mn = view.adminMiddleNameField.getText();
		String ln = view.adminLastNamefield.getText();
		boolean selected = !view.adListTable.getSelectionModel().isSelectionEmpty();
		
		if( view.adminAddRadioButton.isSelected() ) {

			// model.addAdmin(fn,mn,ln);

		}
		if( view.adminEditRadioButton.isSelected() ) {
			if( selected == false ) JOptionPane.showMessageDialog(null,"Please Select A Row in the Table!");
			else {
				int id = Integer.parseInt(view.adminIDField.getText());
				
				// update UI
				TableModel tModel = view.adListTable.getModel();
				int i = view.adListTable.getSelectedRow();
				tModel.setValueAt(fn, i, 1);
				tModel.setValueAt(mn, i, 2);
				tModel.setValueAt(ln, i, 3);
				
				// update DB
				Admin nAdmin = new Admin(id, fn, mn, ln);
				sAdModel.addAdmin(nAdmin);
				
				// alert UI
				JOptionPane.showMessageDialog(null, "Saved!");
			}
		}
	}
}
