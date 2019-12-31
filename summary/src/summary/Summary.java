package summary;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.AbstractAction;


public class Summary extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Scanner s;
	String xx = null;
	String dir="";
	private JTextField textField;
	private JTextField textField_1;
	StringBuilder sb =new StringBuilder();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Summary frame = new Summary();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	// make right click
	public class CutCopyPastActionSupport {
private JMenu jMenu;
JPopupMenu popupMenu = new JPopupMenu();

public CutCopyPastActionSupport() {
   init();
	  }

private void init() {
jMenu = new JMenu("Edit");
addAction(new DefaultEditorKit.CutAction(), KeyEvent.VK_X, "Cut" );
addAction(new DefaultEditorKit.CopyAction(), KeyEvent.VK_C, "Copy" );
addAction(new DefaultEditorKit.PasteAction(), KeyEvent.VK_V, "Paste" );
  }
private void addAction(TextAction action, int key, String text) {
action.putValue(AbstractAction.ACCELERATOR_KEY,
KeyStroke.getKeyStroke(key, InputEvent.CTRL_DOWN_MASK));
action.putValue(AbstractAction.NAME, text);
jMenu.add(new JMenuItem(action));
popupMenu.add(new JMenuItem(action));
		  }
public void setPopup(JTextComponent... components){
if(components == null){
return;
}
for (JTextComponent tc : components) {
tc.setComponentPopupMenu(popupMenu);
}
}

public JMenu getMenu() {
  return jMenu;
		  }
		}
	
////	
	
public Summary() throws FileNotFoundException{
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 1300, 700);
contentPane = new JPanel();
contentPane.setBackground(new Color(0, 0, 51));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
tabbedPane.setBounds(10, 0, 995, 661);
contentPane.add(tabbedPane);

JPanel panel = new JPanel();
tabbedPane.addTab("Source", null, panel, null);
panel.setLayout(null);
		
JTextArea textArea = new JTextArea();


JPanel panel_1 = new JPanel();
tabbedPane.addTab("Result", null, panel_1, null);
panel_1.setLayout(null);

JTextArea textArea2 = new JTextArea();
textArea2.setFont(new Font("Monospaced", Font.PLAIN, 18));
textArea2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
textArea2.setBounds(10, 11, 970, 611);
textArea2.setLineWrap(true);

panel_1.add(textArea2);
JScrollPane scrollPane2 = new JScrollPane(textArea2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scrollPane2.setBounds(10, 11, 970, 611);
panel_1.add(scrollPane2);



// make right click
CutCopyPastActionSupport support = new CutCopyPastActionSupport();
support.setPopup(textArea,textArea2);
JMenuBar menuBar = new JMenuBar();
menuBar.add(support.getMenu());
setJMenuBar(menuBar);
///


textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
textArea.setBounds(10, 11, 970, 611);
textArea.setLineWrap(true);
panel.add(textArea);
		
JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scrollPane.setBounds(10, 11, 970, 611);
panel.add(scrollPane);
		
JButton btnNewButton = new JButton("Brows");
btnNewButton.setBounds(1015, 44, 135, 39);
btnNewButton.setBackground(SystemColor.textHighlight);
btnNewButton.setForeground(SystemColor.desktop);
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));

contentPane.add(btnNewButton);
		
JTextArea textArea_1 = new JTextArea();
textArea_1.setBounds(1184, 95, 66, 23);
textArea_1.setForeground(Color.WHITE);
textArea_1.setBackground(new Color(0, 0, 102));
textArea_1.setFont(new Font("Monospaced", Font.BOLD, 16));
contentPane.add(textArea_1);
		
JTextArea textArea_2 = new JTextArea();
textArea_2.setBounds(1184, 129, 66, 23);
textArea_2.setForeground(Color.WHITE);
textArea_2.setBackground(new Color(0, 0, 102));
textArea_2.setFont(new Font("Monospaced", Font.BOLD, 16));
contentPane.add(textArea_2);
		

		

ArrayList<String>list1=new ArrayList<String>();
ArrayList<String>list2=new ArrayList<String>();
ArrayList<String>list3=new ArrayList<String>();		
ArrayList<String>list5=new ArrayList<String>();
ArrayList<String>list6=new ArrayList<String>();
ArrayList<Integer>list7=new ArrayList<Integer>();
ArrayList<String>list8=new ArrayList<String>();
ArrayList<Integer>list9=new ArrayList<Integer>();
ArrayList<String>list10=new ArrayList<String>();
ArrayList<Integer>list11=new ArrayList<Integer>();
ArrayList<String>list12=new ArrayList<String>();
ArrayList<Integer>list13=new ArrayList<Integer>();
ArrayList<String>list14=new ArrayList<String>();
ArrayList<Integer>list15=new ArrayList<Integer>();
ArrayList<String>list16=new ArrayList<String>();
ArrayList<Integer>list17=new ArrayList<Integer>();
ArrayList<String>lk=new ArrayList<String>();
ArrayList<String>li=new ArrayList<String>();
ArrayList<String>ll=new ArrayList<String>();
ArrayList<String>e=new ArrayList<String>();
ArrayList<String>r=new ArrayList<String>();
ArrayList<String>jk=new ArrayList<String>();
ArrayList<String>list333=new ArrayList<String>();
ArrayList<String>list33=new ArrayList<String>();
btnNewButton.addActionListener(new ActionListener() {
		

public void actionPerformed(ActionEvent arg0) {
		
	
JFileChooser ch=new JFileChooser();
ch.showOpenDialog(null);
File f=ch.getSelectedFile();
dir=f.getAbsolutePath();
InputStreamReader in = null;
try {
	in = new InputStreamReader(new FileInputStream(dir));
} catch (FileNotFoundException e) {
	e.printStackTrace();
}
s = new Scanner(in); 


while(s.hasNext()) {
	
	
	try {
		xx = new String(s.next().getBytes(), "UTF-8");
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}

	list1.add(xx);
	
	}

s.close();
int t=list1.size();
if(t==0 || t==1)
{JOptionPane.showMessageDialog(panel, "File is Empty !");}

		
}
});



JButton btnNewButton_1 = new JButton("Summarization");
btnNewButton_1.setBounds(1015, 176, 135, 39);
btnNewButton_1.setBackground(SystemColor.textHighlight);
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
if(textArea_1.getText().equals(""))	
{	
JOptionPane.showMessageDialog(textArea_1, "plz enter word percantage");	
}
else if(textArea_2.getText().equals(""))	
{	
JOptionPane.showMessageDialog(textArea_2, "plz enter sentence percantage");	
}

	
else if(textArea.getText().equals("") && dir=="")
	
{
JOptionPane.showMessageDialog(textArea, "plz upload text file or enter paragraph");	

}	
 

	
else if(dir=="" && ! (textArea.getText().equals("")))				
{			
list1.clear();
list1.add(textArea.getText());	
process(tabbedPane, textArea_1, textArea2, list1);
}	
else if(! (dir=="") && textArea.getText().equals(""))
{
process(tabbedPane, textArea_1, textArea2, list1);	
}

}

public void process(JTabbedPane tabbedPane, JTextArea textArea_1, JTextArea textArea2, ArrayList<String> list1) {

	for(int w=0;w<list1.size();++w) {
	jk.add(list1.get(w));
	int i=jk.size();
	String is=Integer.toString(i);
	textField.setText(is);
	}
	///here put your folder that contain ( arabicstopw0ords ) 
	//s1 = new Scanner(new File("C:\\Users\\net\\Desktop\\stopword.txt"));
	String[] q = {"من","الى","إلى","في","على","ثم","قد","الذي","قبل","لأنها","لا","كما","ما","التي","وعلى","ذلك","تلك","مازالت","منذ","فهي","والتي","بها","مع","عن","وعن","هذه","عليها","حتى","فانه",
	"أيضا","أو","ثم","حسب","كانت","بذلك","أن","ولم","بها","الا","نحو","حيث","الان","وغيرها","اذ","منها","وذلك","في","تم","بعد","أن","بيد","سوى","غير","لاسيما","متى","بكم","بما","بماذا","بمن","كم","كيف","ما","ماذا","مما","ممن","أين","أينما","حيثما","كيفما","مهما","أولئكم","أولاء","أولالك","تلك","تلكم","تلكما","تينك","ذا","ذاك","اه","ذانك","ذلك","ذلكم","ذلكما","ذلكن","ذوا","ذواتا","ذواتي","ذينك","كذلك","هاهنا","هكذا","هنا","هناك","هنالك","أي","بعض","تجاه","تلقاء","جميع","حسب",
	"حيث","سبحان","شبه","كل","لعمر","لما","مثل","مع","معاذ","نحو","أقل","أكثر","حاي","طاق","وا",
	"أمامك","دونك","رويدك","سرعان","عليك","مكانكم","مكانكما","مه","ها","هاؤم","هيت","الألاء","الألى","التي",
	"الذين","اللائي","اللاتي","اللتان","اللتيا","اللتين","اللذان","اللذين","اللواتي","ذا","ذات",
	"أب","أخ","حم","ذو","فو","لن","لو","لولا","لوما","نعم","لات","لا","كي","أجمع","جميع","عامة","عين","كل","كلا",
	"كلاهما","كلتا","كليكما","كليهما","نفس","ء","ؤ","ىء","أ","ب","ت","ث","ة","ج","ح","خ","د","ذ","ر","ز",
	"س","ش","ص","ض","ط","ظ","ع","غ","ف","ق","ك","ل","م","ن","و","ه","ي","ى","حاشا","خلا","عدا",
	"لكن","فيم","فيما","هل","سوف","قد","كما","لكي","لكيلا","منذ","مذ","لم","أجل","بلى","جلل","جير","لئن","ألا","أما",
	"أم","أو","بل","أيا","هيا","أن","بك","بكم","بكما","بكن","بنا","به","بها","بي","لك","لكم","لكما",
	"لكن","لنا","له","لها","لي","أنا","أنت","أنتم","نتما","أنتن","نحن","هم","هما","هن","هو","هي",
	"ريث","عند","عوض","قبل","لدن","لدى","أبدا","أصلا","أمد","أمس","أول","بعد","تارة","حين","صباح","ضحوة","غداة","مساء",
	"يومئذ","خلال","أمام","أين","بين","تحت","خلف","شمال","ضمن","فوق","يمين","حوالى","حول","طالما","قلما","ابتدأ",
	"اخلولق","انبرى","أخذ","أقبل","أنشأ","أوشك","جعل","حرى","شرع","طفق","عسى","علق","قام","كاد","كرب","استحال",
	"انقلب","أصبح","أضحى","أمسى","بات","حار","راح","رجع","صار","عاد","غدا","كان","ماانفك","مابرح","مادام","مازال",
	"مافتىء","بضع","ذيت","فلان","كذا","كم","كيت","أنّى","أيّ","أيّان","أين","أولئك","تانِ","تانِك","تِه","تِيه",
	"تَيْنِ","ثمّ","ثمّة","ذِه","ذِي","ذَيْنِ","هَؤلاء","هَاتانِ","هَاتِه","هَاتِي","هَاتَيْنِ","هَذا","هَذانِ","هَذِه","هَذِي","هَذَيْنِ",
	"إذ","إذا","إذاً","آهاً","صهْ","صهٍ","طَق","عَدَسْ","كِخ","نَخْ","هَجْ","واهاً","وَيْ","آمينَ","آه","أُفٍّ","أُفٍّ","أمامكَ",
	"أوّهْ","إلَيْكَ","إلَيْكَ","إليكَ","إليكم","إليكما","إليكنّ","إيهٍ","بخٍ","بَسْ","بطآن","بَلْهَ","حَذارِ","حيَّ","شَتَّانَ","مكانَك",
	"مكانكنّ","هاكَ","هلمَّ","هيّا","هَيْهَاتَ","وراءَك","وراءَك","كأيّن","كأين","كأيّ","لَسْنَ","لَيْسُوا","لَيْسَتَا","لَيْسَا","لَيْسَتْ",
	"لَسْتُنَّ","لَسْتُم","لَسْتُمَا","لَسْتِ","لَسْتَ","لِسْنَا","لَسْتُ","لَيْسَ","ظلّ","تحوّل","تبدّل","آض","ارتدّ","لكنَّما","إنّما","هبّ","ثمّ",
	"إزاء","مرّة","إذ","أيّان","آنفا","الآن","لمّا","كلّما","قطّ","إياي","إياهن","إياهما","إياهم","إياها","إياه","إيانا",
	"إياكن","إياكما","إياكم","إياك","أنتِ","ثُمَّ","أمّا","إذما","كلَّا","إي","إذن","لمّا","حَتَّى","عَمَّا","مِن","رُبَّ","إلى","كأنّما",
	"إمّا","هلّا","إلّا","آ","آي","لَيْتَ","لَكِنَّ","لَعَلَّ","كَأَنَّ","أَهيُّ","علًّ","إِنَّ","أَنَّ","إن","نِعِمّا","نِعْمَ","سَاءَمَا","سَاءَ","حَبَّذَ","بِئْسَ","مَنْ","وُشْكَانَ","هنالك","أ",
	"هذا","ليس","ان","أ","ابان ","إليها","لأنها","وهذا","أبان","وأبان","لكن","أنها","دون","يكون","انه","وإنما","إنها","إلا","وبعدها","لابد","فيه",
	"هذين","فالكل","معها","عليهم","هاتين","تكون","اجل","علها","ليست","بعدما","البعض","يمكن","نتمكن","فيها","مايمكن","معه","سواء","فقط","جميعها",
	"لكنها","كل","اليها","منها","بدلا","الجميع","فمنهم","لايمكن","يكن","تكن","وكأن","عليه","عنه","مما","بعده","أبعد","ماتكون","بها","إما","ابعد"};

	for(int i=0;i<q.length;i++)
	list2.add(q[i]);
	//System.out.println(list2);
	// list1 is source text
	//list2 is stop word
	//list3 result from delet stop word from list1 
	////delet stop word----------------------------------------// 

	for(int i =0; i< list1.size(); i++)
	list3.add(list1.get(i));
	for(int i =0; i< list1.size(); i++)
	{
	for(int j=0; j< list2.size();j++)
	{
	if(list1.get(i).equals(list2.get(j))) {   	
	list3.remove(list1.get(i));
	  }                  
	 }
	}
	//list 333 for cutting all sentences end with dote (.) 

	for(int i=0;i<jk.size();i++) {
	if(jk.get(i).equals(".")) {
				
	String y="";
	for(int j=0;j<=i;j++) {	
										
	y=(y+" "+jk.get(j));
	
	}
	
	for(int d=i;d>=0;d--) {
	jk.remove(d);	
	}
	list333.add(y);
	i=-1;
	}
	}
	if(jk.size()!=0)
	{
	String qq="";
	for(int t=0;t<jk.size();t++)
	{
	qq=qq+" "+jk.get(t);
	}
				
	list333.add(qq);
	for(int e=0;e<jk.size();e++)
	jk.remove(e);	
	
	}

	//list 33 for cutting all sentences contain with dote (.) in list333 
	
	int j2;
	String h;
	String h2;
	int l;
	for(int i=0;i<list333.size();i++) {
	l=list333.get(i).length();
	if(list333.get(i).contains(".")||list333.get(i).substring(l-1).equals(".")){	
				
	for(int j=0;j<list333.get(i).length();j++) {	
	j2=j+1;	
	if(list333.get(i).substring(j,j2).equals(".")) {
	h=list333.get(i).substring(0,j2);
	h2=list333.get(i).substring(j2,l);
	list33.add(h);
	list33.add(h2);
	break;
	}
	}
	
	}
	else
	list33.add(list333.get(i));
	}
	
	//the end and begin of word is divide to three array the 1st is one word the other is 2 or 3 word >>it is for the delete and compare between word
	String []pr ={"س","ف","و","ل","ب","ك","أ","ن","ي","ت"};
	String []pr2= {"سا","سن","سي","ست","لل","فل","فس","وس","ول","وب","وت","ال","لل"};  
	String []pr3 = {"فال","وال","بال"};
	String []su= {"ك","ة","ا","ت","ن","ه","و","ي"};
	String []su2 = {"ية","هم","هن","نا","تم","تن","ين","ها","كم","كن","وا","ان","ون","ني","ات","وه","يه","ما","ته","يا"};
	String []su3={"تما","هما"};
	//list for the source word and frequency and saperate comma
	int w=0;
	int j=0;

	for(w=0;w<list3.size();++w) {
	lk.add(list3.get(w));
			}


	String jh="";
	for(w=0;w<lk.size();++w) {
	int pk=lk.get(w).length();
	if(lk.get(w).substring(0, 1).equals("،")||lk.get(w).substring(0, 1).equals(".")||lk.get(w).substring(0, 1).equals(";")||lk.get(w).substring(0, 1).equals(")")||lk.get(w).substring(0, 1).equals("("))
	{	
	jh=lk.get(w).substring(1);
	ll.add(jh);
	}
	else if(lk.get(w).substring(pk-1,pk).equals(".")||lk.get(w).substring(pk-1,pk).equals("،")||lk.get(w).substring(pk-1,pk).equals(";")||lk.get(w).substring(pk-1,pk).equals(")")||lk.get(w).substring(pk-1,pk).equals("("))	
	{
	jh=lk.get(w).substring(0,pk-1);
	ll.add(jh);	
	}
	else if(lk.get(w).contains(".")||lk.get(w).contains("،")||lk.get(w).contains(";")||lk.get(w).contains("(")||lk.get(w).contains(")")) {
	for(int io=0;io<lk.get(w).length();io++) {
	int io2=io+1;
	if(lk.get(w).substring(io,io2).equals("،")||lk.get(w).substring(io,io2).equals(";")||lk.get(w).substring(io,io2).equals(".")||lk.get(w).substring(io,io2).equals(")")||lk.get(w).substring(io,io2).equals("(")) {
	jh=lk.get(w).substring(0, io);
	ll.add(jh);
	jh=lk.get(w).substring(io+1,pk);
	ll.add(jh);
	} 
	}}
	else ll.add(lk.get(w));	
	}

	for(w=0;w<ll.size();++w) {
	li.add(ll.get(w));
	}

	for(int i =0; i< ll.size(); i++)
	{
	for(int jj=0; jj< list2.size();jj++)
	 {
	if(ll.get(i).equals(list2.get(jj))) {   	
	li.remove(ll.get(i));
	  }                  
	 }
	}


	//1

	if(li.size()!=0) {
	for(int t =0; t<li.size(); t++) {
		
	if  ((li.get(t)).length() > 3 )   {
	for ( j = 0; j < pr3.length; j++) {
	if ((li.get(t).substring(0,3)).equals(pr3[j])) {

	String s1=li.get(t).substring(3);

	e.add(s1);
	li.remove(t);
	
	if(t==li.size()) {break;}
	
	else if(t==0) {					
	continue;					
	}
	else
	--t;
	
	
	
	}
	}
			}
	else if(li.size()!=0) {
	if(li.get(t).length()<4)
	{
					
	list5.add(li.get(t));
	li.remove(t);
	if(t==li.size()) {break;}
	
	else if(t==0) {					
	continue;					
	}
	else
	--t;
	}
				
			
	}
		
	}}
	if(li.size()!=0) {
	if  ((li.get(0)).length() > 3 )   {
	for ( j = 0; j < pr3.length; j++) {
	if ((li.get(0).substring(0,3)).equals(pr3[j])) {
	String s1=li.get(0).substring(3);
	e.add(s1);
	li.remove(0);
	break;	}}}}
	if(li.size()!=0) {
	if  ((li.get(0)).length() < 4 )	
	{	list5.add(li.get(0));
	li.remove(0);
		}}
	//2

	if(li.size()!=0) {
	for(int t =0; t<li.size(); t++) {
							
								
	if  (((li.get(t)).length()) > 3)   {
	for ( j = 0; j < pr2.length; j++) {
	if ((li.get(t).substring(0,2)).equals(pr2[j])) {
	String s1=li.get(t).substring(2);

	e.add(s1);
						
	li.remove(t);
	
	if(t==li.size()) {break;}
	
	else if(t==0) {	continue;}
	else --t;
	
	}}}}}
	
	if(li.size()!=0) {
	if  ((li.get(0)).length() > 3 )   {
	for ( j = 0; j < pr2.length; j++) {
	if ((li.get(0).substring(0,2)).equals(pr2[j])) {

	String s1=li.get(0).substring(2);

	e.add(s1);
	
	li.remove(0);
	break;
	}}}}
	
	//3

	if(li.size()!=0) {
	for(int i =0; i<li.size(); i++)
	{
								
						
	if  (((li.get(i)).length()) > 3 )   {
	for ( j = 0; j < pr.length; j++) {
									
	if((li.get(i).substring(0,1)).equals(pr[j])) {	
	String s=li.get(i).substring(1);
	e.add(s);
	li.remove(i);
	if(i==li.size()) {break;}
	else
	if(i==0) {					
	continue;				
	}
	else
	--i;	
		}}}}}	
	
	if(li.size()!=0) {
	if  ((li.get(0)).length() > 3 )   {
	for ( j = 0; j < pr.length; j++) {
				
	if((li.get(0).substring(0,1)).equals(pr[j])) {	
	String s=li.get(0).substring(1);
	e.add(s);
	li.remove(0);
	break;}}}}
					
	//1

	if(li.size()!=0) {
	for(int i =0; i<li.size(); i++)
	{
								
								
	if  ((li.get(i)).length() > 3 )   {
	for ( j = 0; j < su3.length; j++) {
	int p=li.get(i).length();	
	if((li.get(i).substring(p-3,p).equals(su3[j]))) {	

	String s=li.get(i).substring(0,p-3);

	r.add(s);
	li.remove(i);
									
	if(i==li.size()) {break;}
												
	else if(i==0) {					
	continue;			
		}
									
	else	--i;
									
									
	}}}}}	
	
	if(li.size()!=0) {
	if  ((li.get(0)).length() > 3 )   {
	for ( j = 0; j < su3.length; j++) {
	int p=li.get(0).length();	
	if((li.get(0).substring(p-3,p).equals(su3[j]))) {	

	String s=li.get(0).substring(0,p-3);

	r.add(s);
	li.remove(0);
	break;}}}}
	
	//2

	if(li.size()!=0) {
	for(int i =0; i<li.size(); i++)
	{
								
								
	if  ((li.get(i)).length() > 3 )   {
	for ( j = 0; j < su2.length; j++) {
	int p=li.get(i).length();	
	if((li.get(i).substring(p-2,p).equals(su2[j]))) {	
	//System.out.println(su2[j]+"rrrrr");
	String s=li.get(i).substring(0,p-2);
	r.add(s);
	li.remove(i);
				
									
	if(i==li.size()) {break;}
								
	else if(i==0) {					
	continue;				
	}
								
	else	{--i;
							
	}
	
	}}}}	}		
	if(li.size()!=0) {
	if  ((li.get(0)).length() >3 )   {
	for ( j = 0; j < su2.length; j++) {
	int p=li.get(0).length();	
	if((li.get(0).substring(p-2,p).equals(su2[j]))) {	

	String s=li.get(0).substring(0,p-2);
	r.add(s);
	li.remove(0);
	break;}}}}

	//3	
							
	if(li.size()!=0) {
	for(int i =0; i<li.size(); i++)
	{
					
					
	if  ((li.get(i)).length() > 3 )   {
	for ( j = 0; j < su.length; j++) {
	int p=li.get(i).length();	
	if((li.get(i).substring(p-1,p).equals(su[j]))) {	

	String s=li.get(i).substring(0,p-1);
	r.add(s);
	li.remove(i);						
	if(i==li.size()) {break;}
						
	else	if(i==0) {					
	continue;			
	}
						
	else	--i;
	}}}}}
	if(li.size()!=0) {
	if  ((li.get(0)).length() > 5 )   {
	for ( j = 0; j < su.length; j++) {
	int p=li.get(0).length();	
	if((li.get(0).substring(p-1,p).equals(su[j]))) {	

	String s=li.get(0).substring(0,p-1);
	r.add(s);
	li.remove(0);	
	break;}}}}

	if(li.size()!=0) {
	for (int mn=0;mn<li.size();++mn) {	
	list5.add(li.get(mn));
				
	li.remove(mn);
					
	}}
	//			System.out.println("finish initial cutting");

				
				
	//1
			
	if(e.size()!=0) {
	for(int i =0; i<e.size(); i++)
	{
				
				
	if  ((e.get(i)).length()>3 )   {
	for ( j = 0; j < su3.length; j++) {
	int p=e.get(i).length();	
	if((e.get(i).substring(p-3,p).equals(su3[j]))) {	

	String s=e.get(i).substring(0,p-3);
	
	list5.add(s);
				
	e.remove(i);		
	if(i==e.size()) {break;}
					
	else	if(i==0) {					
	continue;			
	}
			
	else	--i;
		}}}}}
	if(e.size()!=0) {
	if  ((e.get(0)).length()>3 )   {
				
	for ( j = 0; j < su3.length; j++) {
	int p=e.get(0).length();	
	if((e.get(0).substring(p-3,p).equals(su3[j]))) {	
	String s=e.get(0).substring(0,p-3);
	
	list5.add(s);
	
	e.remove(0);		
	break;}}}}
	//2
	
	if(e.size()!=0) {
	for(int i =0; i<e.size(); i++)
	{
				
				
	if  ((e.get(i)).length() >3 )   {
	for ( j = 0; j < su2.length; j++) {
	int p=e.get(i).length();	
	if((e.get(i).substring(p-2,p).equals(su2[j]))) {	
	String s=(e.get(i)).substring(0,p-2);
	list5.add(s);
	e.remove(i);
	
	if(i==e.size()) {break;}
		
	else	if(i==0) {					
	continue;			
			}
				
	else	--i;
		}}}}	}	
	if(e.size()!=0) {
	if  ((e.get(0)).length() >3 )   {
	for ( j = 0; j < su2.length; j++) {
	int p=e.get(0).length();	
	if((e.get(0).substring(p-2,p).equals(su2[j]))) {	

	String s=(e.get(0)).substring(0,p-2);
	list5.add(s);
	e.remove(0);
	break;}}}}

	//3			
	if(e.size()!=0) {
	for(int i =0; i<e.size(); i++)
	{
	
	
	if  ((e.get(i)).length() >3 )   {
	for ( j = 0; j < su.length; j++) {
	int p=e.get(i).length();	
	if((e.get(i).substring(p-1,p).equals(su[j]))) {	
	String s=e.get(i).substring(0,p-1);
	list5.add(s);
	e.remove(i);						
	if(i==e.size()) {break;}
	
	else if(i==0) {					
	continue;		
			}
	
	else --i;
	}}}}	}
	
	if(e.size()!=0) {
	if  ((e.get(0)).length() >3 )   {
	for ( j = 0; j < su.length; j++) {
	int p=e.get(0).length();	
	if((e.get(0).substring(p-1,p).equals(su[j]))) {	

	String s=e.get(0).substring(0,p-1);
	list5.add(s);
	e.remove(0);		break;		}}}}

	if(e.size()!=0) {
	for(int b=0;b<e.size();b++) {
	list5.add(e.get(b));
	}}
	//System.out.println("finish eee");
	//System.out.println("result "+list5);

	
	//1
	if(r.size()!=0) {
	for(int i =0; i<r.size(); i++)
	{
				
				
	if  ((r.get(i)).length() >3 )   {
	for ( j = 0; j < pr3.length; j++) {
						
	if((r.get(i).substring(0,3).equals(pr3[j]))) {	

	String s=r.get(i).substring(3);
	
	list5.add(s);
					
	r.remove(i);		
	if(i==r.size()) {break;}
					
	else		if(i==0) {					
		continue;				
	}
					
	else	--i;
	}}}}}	
	if(r.size()!=0) {
	if  ((r.get(0)).length() >3 )   {
			
	for ( j = 0; j < pr3.length; j++) {
				
	if((r.get(0).substring(0,3).equals(pr3[j]))) {	

	String s=r.get(0).substring(3);
	
	list5.add(s);
	
	r.remove(0);break;	}}}}
	
	//2
	
	if(r.size()!=0) {
	for(int i =0; i<r.size(); i++)
	{
				
				
	if  ((r.get(i)).length() >3 )   {
	for ( j = 0; j < pr2.length; j++) {
							
	if((r.get(i).substring(0,2).equals(pr2[j]))) {	
	String s=(e.get(i)).substring(2);
	list5.add(s);
					
	r.remove(i);
	
	if(i==r.size()) {break;}
				
	else	if(i==0) {					
	continue;			
			}
				
	else	--i;
		}}}}}	
	if(r.size()!=0) {
	if  ((r.get(0)).length() >3 )   {
	for ( j = 0; j < pr2.length; j++) {
				
	if((r.get(0).substring(0,2).equals(pr2[j]))) {	
	String s=(e.get(0)).substring(2);
	list5.add(s);
					
	r.remove(0);
	break;}}}}

	//3			
	if(r.size()!=0) {
	for(int i =0; i<r.size(); i++)
	{
	
	
	if  ((r.get(i)).length()>3)   {
	for ( j = 0; j < pr.length; j++) {
				
	if((r.get(i).substring(0,1).equals(pr[j]))) {	
	String s=e.get(i).substring(1);
	list5.add(s);
	r.remove(i);						
	if(i==r.size()) {break;}
	else if(i==0) {					
	continue;				
		}
	
	else --i;
	}}}}}			
	if(r.size()!=0) {
	if  ((r.get(0)).length()>3 )   {
		for ( j = 0; j < pr.length; j++) {
	if((r.get(0).substring(0,1).equals(pr[j]))) {	

	String s=e.get(0).substring(1);
	list5.add(s);
	r.remove(0);
	break;
	}}}}

	if(r.size()!=0) {
	for(int b=0;b<r.size();b++) {
	list5.add(r.get(b));
			}}

	for(int p=0;p<list5.size();p++) {	
	if(list5.get(p).equals(",")||list5.get(p).equals("،")||list5.get(p).equals(".")||list5.get(p).equals("؛")||list5.get(p).equals("?")||list5.get(p).equals("!")||list5.get(p).equals("")) {	

	list5.remove(p);

	if(p==list5.size()) {break;}
	else if(p==0) {					
	continue;					
	}
	else --p;
	}
	}				
	int r22=list5.size();
	String is2=Integer.toString(r22);
	textField_1.setText(is2);
	
	if(list5.get(0).equals(",")||list5.get(0).equals("،")||list5.get(0).equals(".")||list5.get(0).equals("؛")||list5.get(0).equals("?")||list5.get(0).equals("!")||list5.get(0).equals("")) {	
	list5.remove(0);}


	for(int pp=0;pp<list5.size();pp++) {
	list6.add(list5.get(pp));
	}

	int n=0;
	for (int oo=0;oo<list6.size();oo++) {
	n=0;
	for(int ooo=oo+1;ooo<list6.size();ooo++) {	
	if(list6.get(oo).equals(list6.get(ooo))) {
	n=n+1;	
	list6.remove(ooo);
	--ooo;
	}
	}
	list7.add(n);
	if(oo==list6.size()-1) {
	break;	
	}
	}
	// here we Descending frequency and  its corresponds word
	//list 8 for words Descending (its same list 6 but Descending)
	//list 9 for frequency Descending (its same list 7 but Descending)

	int a=0;
	for (int oo=0;oo<list7.size();oo++) {
	a=0;
	for(int ooo=0;ooo<list7.size();ooo++) {	
	if(list7.get(oo)>=(list7.get(ooo))) { 
	a++;
	}
	else
	break;
	}
	if(a==list7.size())
	{
	list8.add(list6.get(oo));
	list9.add(list7.get(oo));
	list7.remove(oo);
	list6.remove(oo);
	oo=-1;
	}
	}
	//sum the freq of word
	int s=0;
	for(int y=0;y<list9.size();y++) {
	s=s+list9.get(y);	
	}
	//input percent of word and cal the result
	int t=Integer.parseInt(textArea_1.getText());

	int u=(t/100)*s;

	// bring the word which within cal u

	int tt=0;
	for(int i=0;i<list9.size();i++)
	{
	list10.add(list8.get(i));
	list11.add(list9.get(i));
	tt=tt+list9.get(i)	;
	if(tt>=u) break;
	}
	//calculate the ferq of sentences
	int rr=0;

	for(int i=0;i<list33.size();i++)
	{
	rr=0;
	for(int jj=0;jj<list10.size();jj++)
	{
	if(list33.get(i).contains(list10.get(jj)))
	rr=rr+list11.get(jj);
	else rr=rr+0;
		}
	list12.add(list33.get(i));
	list13.add(rr);
	}
	//here we Descending frequency and sentences
	//list 8 for sentence Descending (its same list12 but Descending)
	//list 9 for frequency Descending (its same list13 but Descending)

	int aa=0;
	for (int oo=0;oo<list13.size();oo++) {
	aa=0;
	for(int ooo=0;ooo<list13.size();ooo++) {	
	if(list13.get(oo)>=(list13.get(ooo))) { 
	aa++;
	}
	else
	break;
	}
	if(aa==list13.size())
	{
	list14.add(list12.get(oo));
	list15.add(list13.get(oo));
	list13.remove(oo);
	list12.remove(oo);
	oo=-1;
	}
	}
	//sum freq of sentence
	int ss=0;
	for(int y=0;y<list15.size();y++) {
	ss=ss+list15.get(y);	
	}

	//input percent of sentences and cal the result
	int g=Integer.parseInt(textArea_1.getText());
	int bb=(g/100)*ss;

	//bring the word which within cal u

	int ttt=0;
	for(int i=0;i<list15.size();i++)
	{
	list16.add(list14.get(i));
	list17.add(list15.get(i));
	ttt=ttt+list15.get(i)	;
	if(ttt>=bb) break;
	}
	int r2=list16.size();
	
	for (int i = 0; i < r2; i++) {
	sb.append(list16.get(i));
	}
	

	
	textArea2.setText(sb.toString());
	tabbedPane.setSelectedIndex(1);
	
}});
contentPane.add(btnNewButton_1);
JButton btnNewButton_2 = new JButton("Clear");
btnNewButton_2.setBounds(1015, 325, 135, 39);
btnNewButton_2.setBackground(SystemColor.textHighlight);
btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
btnNewButton_2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		dir="";
		textArea.setText("");
		textArea2.setText("");	
		textArea_1.setText("");
		textArea_2.setText("");
		textField.setText("");
		textField_1.setText("");
		list1.clear();
		lk.clear();
		list2.clear();
		list3.clear();
		list5.clear();
		list6.clear();
		list7.clear();
		list8.clear();
		list9.clear();
		list10.clear();
		list11.clear();
		list12.clear();
		list14.clear();
		list13.clear();
		list15.clear();
		list16.clear();
		list17.clear();
		e.clear();
		r.clear();
		ll.clear();
		li.clear();
		sb.delete(0, sb.length());
		list333.clear();
		list33.clear();
		jk.clear();
		tabbedPane.setSelectedIndex(0);
		
			
	}
});
contentPane.add(btnNewButton_2);
JLabel lblNewLabel = new JLabel("Source Word No.");
lblNewLabel.setBounds(1015, 241, 125, 14);
lblNewLabel.setForeground(Color.LIGHT_GRAY);
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
contentPane.add(lblNewLabel);
JLabel lblResultWordNo = new JLabel("Result Word No.");
lblResultWordNo.setBounds(1015, 266, 125, 14);
lblResultWordNo.setForeground(Color.LIGHT_GRAY);
lblResultWordNo.setFont(new Font("Tahoma", Font.BOLD, 14));
contentPane.add(lblResultWordNo);
textField = new JTextField();
textField.setBounds(1184, 238, 66, 23);
textField.setForeground(Color.WHITE);
textField.setBackground(new Color(0, 0, 102));
textField.setFont(new Font("Tahoma", Font.BOLD, 14));
contentPane.add(textField);
textField.setColumns(10);
textField_1 = new JTextField();
textField_1.setBounds(1184, 267, 66, 23);
textField_1.setForeground(Color.WHITE);
textField_1.setBackground(new Color(0, 0, 102));
textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
textField_1.setColumns(10);
contentPane.add(textField_1);
JButton btnExit = new JButton("Exit");
btnExit.setBounds(1015, 400, 135, 39);
btnExit.setBackground(SystemColor.textHighlight);
btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
btnExit.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
	System.exit(0);
	}
});
contentPane.add(btnExit);
JLabel lblWordPercentage = new JLabel("Word percentage");
lblWordPercentage.setBounds(1015, 95, 125, 23);
lblWordPercentage.setForeground(Color.LIGHT_GRAY);
lblWordPercentage.setFont(new Font("Tahoma", Font.BOLD, 14));
contentPane.add(lblWordPercentage);
JLabel lblSentencePercentage = new JLabel("Sentence percentage");
lblSentencePercentage.setBounds(1015, 129, 146, 23);
lblSentencePercentage.setForeground(Color.LIGHT_GRAY);
lblSentencePercentage.setFont(new Font("Tahoma", Font.BOLD, 14));
contentPane.add(lblSentencePercentage);
JButton btnSave = new JButton("Save as Text");
btnSave.setBounds(1015, 474, 135, 39);
btnSave.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) {

JFileChooser ch2=new JFileChooser();
ch2.showOpenDialog(null);
File f2=ch2.getSelectedFile();
String dir2=f2.getAbsolutePath();
String gf=dir2+".txt";
	
try {
	OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(gf), StandardCharsets.UTF_8);
	try {
		writer.write(sb.toString());
		writer.flush(); writer.close();

	} catch (IOException e) {
		
		e.printStackTrace();
	}
} catch (FileNotFoundException e) {
	
	e.printStackTrace();
}	  
		
		

	}
});
btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
btnSave.setBackground(SystemColor.textHighlight);
contentPane.add(btnSave);
JButton btnSaveAsWord = new JButton("Save as Word");
btnSaveAsWord.setBounds(1015, 548, 135, 39);
btnSaveAsWord.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) {
		
		String dir2;
		JFileChooser ch2=new JFileChooser();
		ch2.showOpenDialog(null);
		File f2=ch2.getSelectedFile();
		dir2=f2.getAbsolutePath();
		PrintWriter pr = null;
		try {
		 pr= new PrintWriter(dir2+".docx");
		pr.print(textArea2.getText());
		} catch (FileNotFoundException e) {
	
			e.printStackTrace();
		}finally {
			pr.close();
		}
		
		
	}
});
btnSaveAsWord.setFont(new Font("Tahoma", Font.BOLD, 14));
btnSaveAsWord.setBackground(SystemColor.textHighlight);
contentPane.add(btnSaveAsWord);
JLabel lblUploadTextFile = new JLabel("Upload Text File ");
lblUploadTextFile.setFont(new Font("Tahoma", Font.BOLD, 14));
lblUploadTextFile.setForeground(new Color(255, 0, 0));
lblUploadTextFile.setBounds(1015, 11, 170, 27);
contentPane.add(lblUploadTextFile);


	}
}
