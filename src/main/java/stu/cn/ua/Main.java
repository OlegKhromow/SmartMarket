package stu.cn.ua;

import stu.cn.ua.controller.LogginController;
import stu.cn.ua.view.LoggingView;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        LogginController controller = new LogginController(new LoggingView());
    }
}