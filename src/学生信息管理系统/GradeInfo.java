package 学生信息管理系统;

import javax.swing.*;
import java.awt.*;

/**
 * 成绩信息综合管理类
 * 提供主界面，供其他类继承
 */
public class GradeInfo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container contentPane;
	JPanel centerPanel = new JPanel();
	JPanel upPanel = new JPanel();
	JPanel downPanel = new JPanel();

	//框架的大小
	Dimension faceSize = new Dimension(800, 500);

	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();

	String[] stu = null;//记录所有的学号
	String[] cReturn = null;//记录学生的选课信息

	JComboBox sNum;
	JTextField sName = new JTextField(15);
	JTextField cNum = new JTextField(15);
	JComboBox cName;
	JTextField cTeacher = new JTextField(15);
	JTextField Grade = new JTextField(15);
	JTextField sMajor = new JTextField(15);
	JTextField sCollege = new JTextField(15);
	JTextField sHome = new JTextField(46);
	JButton searchInfo = new JButton();
	JButton addInfo = new JButton();
	JButton modifyInfo = new JButton();
	JButton delInfo = new JButton();
	JButton deleteInfo = new JButton();
	JButton clearInfo = new JButton();
	JButton saveInfo = new JButton();
	JButton eixtInfo = new JButton();

	GridBagLayout girdBag = new GridBagLayout();
	GridBagConstraints girdBagCon;

	public GradeInfo() {
		this.setSize(faceSize);
		this.setResizable(false);
		//设置标题
		//this.setTitle("成绩综合信息管理"); 
		

		try	{
			Init();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void Init() throws Exception {
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		//中部面板的布局
		centerPanel.setLayout(girdBag);

		jLabel1.setText("学        号：");
		jLabel1.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel1,girdBagCon);
		centerPanel.add(jLabel1);

		StuBean sN = new StuBean();
		stu = sN.getAllId();
		sNum = new JComboBox(stu);
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 0;
		girdBagCon.fill = girdBagCon.BOTH;
		girdBagCon.insets = new Insets(10,1,10,15);
		sNum.setSelectedItem(null);
		girdBag.setConstraints(sNum,girdBagCon);
		centerPanel.add(sNum);

		jLabel2.setText("姓        名：");
		jLabel2.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,15,10,1);
		girdBag.setConstraints(jLabel2,girdBagCon);
		centerPanel.add(jLabel2);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,1,10,10);
		sName.setEnabled(false);
		girdBag.setConstraints(sName,girdBagCon);
		centerPanel.add(sName);

		jLabel3.setText("课程名称：");
		jLabel3.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel3,girdBagCon);
		centerPanel.add(jLabel3);
		
		cName = new JComboBox();
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 1;
		girdBagCon.fill = girdBagCon.BOTH;
		girdBagCon.insets = new Insets(10,1,10,15);
		girdBag.setConstraints(cName,girdBagCon);
		centerPanel.add(cName);

		jLabel4.setText("课程编码：");
		jLabel4.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,15,10,1);
		girdBag.setConstraints(jLabel4,girdBagCon);
		centerPanel.add(jLabel4);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,1,10,10);
		cNum.setEditable(false);
		girdBag.setConstraints(cNum,girdBagCon);
		centerPanel.add(cNum);

		jLabel5.setText("授课老师：");
		jLabel5.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel5,girdBagCon);
		centerPanel.add(jLabel5);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10,1,10,15);
		cTeacher.setEnabled(false);
		girdBag.setConstraints(cTeacher,girdBagCon);
		centerPanel.add(cTeacher);

		jLabel6.setText("成        绩：");
		jLabel6.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10,15,10,1);
		girdBag.setConstraints(jLabel6,girdBagCon);
		centerPanel.add(jLabel6);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.insets = new Insets(10,1,10,10);
		girdBag.setConstraints(Grade,girdBagCon);
		centerPanel.add(Grade);

		contentPane.add(centerPanel,BorderLayout.CENTER);
	}

	/**
	 * 下部面板的布局
	 */
	public void downInit(){
		searchInfo.setText("查询");
		searchInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(searchInfo);
		addInfo.setText("增加");
		addInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(addInfo);
		modifyInfo.setText("修改");
		modifyInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(modifyInfo);
		deleteInfo.setText("删除");
		deleteInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(deleteInfo);
		saveInfo.setText("保存");
		saveInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(saveInfo);
		clearInfo.setText("清空");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		eixtInfo.setText("退出");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		contentPane.add(downPanel,BorderLayout.SOUTH);
	}

	
}
