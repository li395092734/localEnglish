package com.lydms.local.web;

import com.lydms.local.domain.English;
import com.lydms.local.utils.JdbcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class AddEnglishController extends JFrame {
    private JPanel contentPane;
    private JTextField english;
    private JTextField codeChinese;
    private JTextField chinese;
    private JTextField remark;

    @Autowired
    private JdbcUtils jdbcUtils;

    public AddEnglishController() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        外框的位置和大小
        setBounds(700, 450, 420, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("向本地英语库中添加数据");
//        标题
        JLabel lmessageLabel = new JLabel("少一些功利主义的追求!");
        lmessageLabel.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        lmessageLabel.setBounds(130, 20, 193, 18);
        contentPane.add(lmessageLabel);
        JLabel lmessageLabe2 = new JLabel("多一些不为什么的坚持！");
        lmessageLabe2.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        lmessageLabe2.setBounds(130, 48, 193, 18);
        contentPane.add(lmessageLabe2);

//        填入的框
        JLabel nameLabel = new JLabel("英   语:");
        nameLabel.setBounds(85, 86, 66, 15);
        contentPane.add(nameLabel);

        english = new JTextField();
        english.setBounds(144, 83, 163, 21);
        contentPane.add(english);
        english.setColumns(10);

        JLabel stockLabel = new JLabel("代码中解释:");
        stockLabel.setFont((new Font("微软雅黑", Font.PLAIN, 14)));
        stockLabel.setBounds(65, 120, 80, 15);
        contentPane.add(stockLabel);


        codeChinese = new JTextField();
        codeChinese.setBounds(144, 117, 163, 21);
        contentPane.add(codeChinese);
        codeChinese.setColumns(10);

        JLabel pricLlabel = new JLabel("中   文:");
        pricLlabel.setBounds(85, 155, 54, 15);
        contentPane.add(pricLlabel);

        chinese = new JTextField();
        chinese.setBounds(144, 152, 163, 21);
        contentPane.add(chinese);
        chinese.setColumns(10);

        JLabel concernLable = new JLabel("备   注:");
        concernLable.setBounds(85, 193, 54, 15);
        contentPane.add(concernLable);

        remark = new JTextField();
        remark.setBounds(144, 190, 163, 21);
        contentPane.add(remark);
        remark.setColumns(10);

        JButton insertButton = new JButton("添加");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_insertButton_actionPerformed(arg0);
            }
        });
        insertButton.setBounds(110, 235, 74, 23);
        contentPane.add(insertButton);

        JButton closeButton = new JButton("关闭");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(211, 235, 74, 23);
        contentPane.add(closeButton);
    }

    //添加按钮的单击事件
    protected void do_insertButton_actionPerformed(ActionEvent arg0) {
        //待完成操练开始
        English en = new English();
        en.setEnglish(english.getText());//英语
        en.setCodechinese(codeChinese.getText());//代码中英文
        en.setChinese(chinese.getText());//英文
        en.setRemark(remark.getText());//备注
        en.setDay(null);//日期
        en.setCategory(null);//分类

        if (StringUtils.isEmpty(english.getText()) || StringUtils.isEmpty(english.getText()) || StringUtils.isEmpty(english.getText())) {
            JOptionPane.showMessageDialog(getContentPane(),
                    "请传入数据！！", "信息提示框", JOptionPane.WARNING_MESSAGE);
        } else {
            int result = jdbcUtils.addEnglish(en);
            if (result == 1) {
                //待完成操练结束
                JOptionPane.showMessageDialog(getContentPane(),
                        "数据添加成功！", "信息提示框", JOptionPane.WARNING_MESSAGE);
            } else {
                //待完成操练结束
                JOptionPane.showMessageDialog(getContentPane(),
                        "数据添加失败！", "信息提示框", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    //关闭按钮的单击事件
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }
}