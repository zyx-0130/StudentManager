package 学生信息管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * 学生信息查询模块
 * 根据学生的学院查询学生信息
 */
public class StuSearchScollege extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container contentPane;
	//框架的大小
	
	Dimension faceSize = new Dimension(300, 100);
	JLabel jLabel1 = new JLabel();
	JTextField sCollege = new JTextField(8);
	JButton searchInfo = new JButton();
	
	public StuSearchScollege() {
		//设置标题
		this.setTitle("按学院查询");
		this.setResizable(false);
	
		try {
			Init();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 + 45);
	}
	
	private void Init() throws Exception {
		this.setSize(faceSize);
		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		jLabel1.setText("请输入学院名称: ");
		jLabel1.setFont(new Font("Dialog",0,12));
		contentPane.add(jLabel1);

		sCollege.setText(null);
		sCollege.setFont(new Font("Dialog",0,12));
		contentPane.add(sCollege);

		searchInfo.setText("确定");
		searchInfo.setFont(new Font("Dialog",0,12));
		contentPane.add(searchInfo);

		searchInfo.addActionListener(this);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchInfo) { //查询
			ResultStudent rS = new ResultStudent("scollege",sCollege.getText());
			this.dispose();
		}
	}

	
}
