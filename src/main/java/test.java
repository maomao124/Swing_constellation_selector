import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

/**
 * Project name(项目名称)：Swing星座选择器
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/2
 * Time(创建时间)： 19:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test
{
    private final JPanel panel = new JPanel();
    private final JComboBox<String> comboBox = new JComboBox<>();
    private final JLabel showInfo = new JLabel();
    private final JTextField jTextField = new JTextField(16);

    public test()
    {
        JFrame jFrame = new JFrame("星座");
        comboBox.addItem("请选择：");
        comboBox.addItem("双鱼座");
        comboBox.addItem("水瓶座");
        comboBox.addItem("巨蟹座");
        comboBox.addItem("狮子座");
        panel.add(comboBox);
        JLabel label = new JLabel("添加星座：");
        panel.add(label);
        panel.add(jTextField);
        JButton buttonAdd = new JButton("新增");
        panel.add(buttonAdd);
        JButton buttonDelete = new JButton("删除");
        panel.add(buttonDelete);
        jFrame.add(panel);
        buttonAdd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (jTextField.getText().length() != 0)
                {
                    boolean result = true;
                    for (int i = 0; i < comboBox.getItemCount(); i++)
                    {
                        //System.out.print(comboBox.getItemAt(i) + " ");
                        if (jTextField.getText().equals(comboBox.getItemAt(i)))
                        {
                            result = false;
                        }
                    }
                    if (result)
                    {
                        comboBox.addItem(jTextField.getText());
                        panel.add(showInfo);
                        showInfo.setText("添加成功，内容：" + jTextField.getText());
                        System.out.println("增加：" + jTextField.getText());
                    }
                    else
                    {
                        Toolkit.getDefaultToolkit().beep();
                        panel.add(showInfo);
                        showInfo.setText("添加失败!!! 原因：内容重复");
                    }
                }
                else
                {
                    panel.add(showInfo);
                    showInfo.setText("请输入要添加的星座");
                }
            }
        });
        buttonDelete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (comboBox.getSelectedIndex() != -1)
                {
                    String str = Objects.requireNonNull(comboBox.getSelectedItem()).toString();
                    comboBox.removeItem(str);
                    System.out.println("删除：" + str);
                    panel.add(showInfo);
                    showInfo.setText("删除成功，删除：" + str);
                }
                else
                {
                    panel.add(showInfo);
                    showInfo.setText("请选择要删除的星座");
                }
            }
        });
        comboBox.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                String str = e.getItem().toString();
                System.out.println(str);
                panel.add(showInfo);
                showInfo.setText("当前选择：" + str);
            }
        });
        jFrame.setSize(640, 480);
        jFrame.setLocation(200, 200);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public static void main(String[] args)
    {
        test t = new test();
    }
}
