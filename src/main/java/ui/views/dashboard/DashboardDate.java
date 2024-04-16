package ui.views.dashboard;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;
import javax.swing.JLabel;
import utils.DateUtils;
import ui.custom.SimplePanel;

public class DashboardDate extends SimplePanel {

    private JLabel[] calendarDays;
    private JLabel[] calendarWeekDays;
    private SimplePanel[] calendarDayPanels;

    public DashboardDate() {
        initComponents();
        initCalendar();
        EventQueue.invokeLater(() -> updateCalendar());
    }

    private void updateCalendar() {

        List<Integer> daysOfWeek = DateUtils.getDaysOfCurrentWeek();
        int currentDay = DateUtils.getCurrentDay();

        int i = 0;

        for (JLabel dayLabel : calendarDays) {
            String day = Integer.toString(daysOfWeek.get(i));
            dayLabel.setText(day);

            if (currentDay == daysOfWeek.get(i)) {
                calendarDayPanels[i].setOpacity(1);
                calendarWeekDays[i].setForeground(Color.WHITE);
                dayLabel.setForeground(Color.WHITE);
            }

            i++;
        }

        monthYear.setText(DateUtils.getCurrentMonthAndYear());

    }

    private void initCalendar() {
        calendarDays = new JLabel[] {
                txtSundayDay,
                txtMondayDay,
                txtTuesdayDay,
                txtWednesdayDay,
                txtThursdayDay,
                txtFridayDay,
                txtSaturdayDay
        };

        calendarWeekDays = new JLabel[] {
                txtSunday,
                txtMonday,
                txtTuesday,
                txtWednesday,
                txtThursday,
                txtFriday,
                txtSaturday
        };

        calendarDayPanels = new SimplePanel[] {
                pnlSunday,
                pnlMonday,
                pnlTuesday,
                pnlWednesday,
                pnlThursday,
                pnlFriday,
                pnlSaturday
        };

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monthYear = new javax.swing.JLabel();
        pnlSunday = new ui.custom.SimplePanel();
        txtSunday = new javax.swing.JLabel();
        txtSundayDay = new javax.swing.JLabel();
        pnlMonday = new ui.custom.SimplePanel();
        txtMonday = new javax.swing.JLabel();
        txtMondayDay = new javax.swing.JLabel();
        pnlTuesday = new ui.custom.SimplePanel();
        txtTuesday = new javax.swing.JLabel();
        txtTuesdayDay = new javax.swing.JLabel();
        pnlWednesday = new ui.custom.SimplePanel();
        txtWednesday = new javax.swing.JLabel();
        txtWednesdayDay = new javax.swing.JLabel();
        pnlThursday = new ui.custom.SimplePanel();
        txtThursday = new javax.swing.JLabel();
        txtThursdayDay = new javax.swing.JLabel();
        pnlFriday = new ui.custom.SimplePanel();
        txtFriday = new javax.swing.JLabel();
        txtFridayDay = new javax.swing.JLabel();
        pnlSaturday = new ui.custom.SimplePanel();
        txtSaturday = new javax.swing.JLabel();
        txtSaturdayDay = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setColumnConstraints("");
        setComponentConstraint(
                new String[] { "wrap, spanx", "center", "center", "center", "center", "center", "center", "center" });
        setLayoutConstraints("insets 0, fillx");
        setMinimumSize(new java.awt.Dimension(360, 80));
        setPreferredSize(new java.awt.Dimension(360, 80));
        setRowConstraints("[][grow]");

        monthYear.setBackground(new java.awt.Color(38, 38, 38));
        monthYear.setFont(new java.awt.Font("Inter", 1, 15)); // NOI18N
        monthYear.setForeground(new java.awt.Color(38, 38, 38));
        monthYear.setText("MonthYear");
        add(monthYear);

        pnlSunday.setBackground(new java.awt.Color(47, 43, 67));
        pnlSunday.setArc(25);
        pnlSunday.setColumnConstraints("center");
        pnlSunday.setComponentConstraint(new String[] {});
        pnlSunday.setFlatClientProperty("arc: 20;");
        pnlSunday.setLayoutConstraints("wrap, center");
        pnlSunday.setMinimumSize(new java.awt.Dimension(40, 40));
        pnlSunday.setOpacity(0.0F);
        pnlSunday.setOpaque(false);
        pnlSunday.setPreferredSize(new java.awt.Dimension(40, 40));
        pnlSunday.setRowConstraints("[]0[]");

        txtSunday.setFont(new java.awt.Font("Inter Medium", 0, 9)); // NOI18N
        txtSunday.setForeground(new java.awt.Color(38, 38, 38));
        txtSunday.setText("Sun");
        pnlSunday.add(txtSunday);

        txtSundayDay.setFont(new java.awt.Font("Inter", 1, 11)); // NOI18N
        txtSundayDay.setForeground(new java.awt.Color(38, 38, 38));
        txtSundayDay.setText("0");
        pnlSunday.add(txtSundayDay);

        add(pnlSunday);

        pnlMonday.setBackground(new java.awt.Color(47, 43, 67));
        pnlMonday.setArc(25);
        pnlMonday.setColumnConstraints("center");
        pnlMonday.setComponentConstraint(new String[] {});
        pnlMonday.setFlatClientProperty("arc: 20;");
        pnlMonday.setLayoutConstraints("wrap, center");
        pnlMonday.setMinimumSize(new java.awt.Dimension(40, 40));
        pnlMonday.setOpacity(0.0F);
        pnlMonday.setOpaque(false);
        pnlMonday.setPreferredSize(new java.awt.Dimension(40, 40));
        pnlMonday.setRowConstraints("[]0[]");

        txtMonday.setFont(new java.awt.Font("Inter Medium", 0, 9)); // NOI18N
        txtMonday.setForeground(new java.awt.Color(38, 38, 38));
        txtMonday.setText("Mon");
        pnlMonday.add(txtMonday);

        txtMondayDay.setFont(new java.awt.Font("Inter", 1, 11)); // NOI18N
        txtMondayDay.setForeground(new java.awt.Color(38, 38, 38));
        txtMondayDay.setText("0");
        pnlMonday.add(txtMondayDay);

        add(pnlMonday);

        pnlTuesday.setBackground(new java.awt.Color(47, 43, 67));
        pnlTuesday.setArc(25);
        pnlTuesday.setColumnConstraints("center");
        pnlTuesday.setComponentConstraint(new String[] {});
        pnlTuesday.setFlatClientProperty("arc: 20;");
        pnlTuesday.setLayoutConstraints("wrap, center");
        pnlTuesday.setMinimumSize(new java.awt.Dimension(40, 40));
        pnlTuesday.setOpacity(0.0F);
        pnlTuesday.setOpaque(false);
        pnlTuesday.setPreferredSize(new java.awt.Dimension(40, 40));
        pnlTuesday.setRowConstraints("[]0[]");

        txtTuesday.setFont(new java.awt.Font("Inter Medium", 0, 9)); // NOI18N
        txtTuesday.setForeground(new java.awt.Color(38, 38, 38));
        txtTuesday.setText("Tue");
        pnlTuesday.add(txtTuesday);

        txtTuesdayDay.setFont(new java.awt.Font("Inter", 1, 11)); // NOI18N
        txtTuesdayDay.setForeground(new java.awt.Color(38, 38, 38));
        txtTuesdayDay.setText("0");
        pnlTuesday.add(txtTuesdayDay);

        add(pnlTuesday);

        pnlWednesday.setBackground(new java.awt.Color(47, 43, 67));
        pnlWednesday.setArc(25);
        pnlWednesday.setColumnConstraints("center");
        pnlWednesday.setComponentConstraint(new String[] {});
        pnlWednesday.setFlatClientProperty("arc: 20;");
        pnlWednesday.setLayoutConstraints("wrap, center");
        pnlWednesday.setMinimumSize(new java.awt.Dimension(40, 40));
        pnlWednesday.setOpacity(0.0F);
        pnlWednesday.setOpaque(false);
        pnlWednesday.setPreferredSize(new java.awt.Dimension(40, 40));
        pnlWednesday.setRowConstraints("[]0[]");

        txtWednesday.setFont(new java.awt.Font("Inter Medium", 0, 9)); // NOI18N
        txtWednesday.setForeground(new java.awt.Color(38, 38, 38));
        txtWednesday.setText("Wed");
        pnlWednesday.add(txtWednesday);

        txtWednesdayDay.setFont(new java.awt.Font("Inter", 1, 11)); // NOI18N
        txtWednesdayDay.setForeground(new java.awt.Color(38, 38, 38));
        txtWednesdayDay.setText("0");
        pnlWednesday.add(txtWednesdayDay);

        add(pnlWednesday);

        pnlThursday.setBackground(new java.awt.Color(47, 43, 67));
        pnlThursday.setArc(25);
        pnlThursday.setColumnConstraints("center");
        pnlThursday.setComponentConstraint(new String[] {});
        pnlThursday.setFlatClientProperty("arc: 20;");
        pnlThursday.setLayoutConstraints("wrap, center");
        pnlThursday.setMinimumSize(new java.awt.Dimension(40, 40));
        pnlThursday.setOpacity(0.0F);
        pnlThursday.setOpaque(false);
        pnlThursday.setPreferredSize(new java.awt.Dimension(40, 40));
        pnlThursday.setRowConstraints("[]0[]");

        txtThursday.setFont(new java.awt.Font("Inter Medium", 0, 9)); // NOI18N
        txtThursday.setForeground(new java.awt.Color(38, 38, 38));
        txtThursday.setText("Thur");
        pnlThursday.add(txtThursday);

        txtThursdayDay.setFont(new java.awt.Font("Inter", 1, 11)); // NOI18N
        txtThursdayDay.setForeground(new java.awt.Color(38, 38, 38));
        txtThursdayDay.setText("0");
        pnlThursday.add(txtThursdayDay);

        add(pnlThursday);

        pnlFriday.setBackground(new java.awt.Color(47, 43, 67));
        pnlFriday.setArc(25);
        pnlFriday.setColumnConstraints("center");
        pnlFriday.setComponentConstraint(new String[] {});
        pnlFriday.setFlatClientProperty("arc: 20;");
        pnlFriday.setLayoutConstraints("wrap, center");
        pnlFriday.setMinimumSize(new java.awt.Dimension(40, 40));
        pnlFriday.setOpacity(0.0F);
        pnlFriday.setOpaque(false);
        pnlFriday.setPreferredSize(new java.awt.Dimension(40, 40));
        pnlFriday.setRowConstraints("[]0[]");

        txtFriday.setFont(new java.awt.Font("Inter Medium", 0, 9)); // NOI18N
        txtFriday.setForeground(new java.awt.Color(38, 38, 38));
        txtFriday.setText("Fri");
        pnlFriday.add(txtFriday);

        txtFridayDay.setFont(new java.awt.Font("Inter", 1, 11)); // NOI18N
        txtFridayDay.setForeground(new java.awt.Color(38, 38, 38));
        txtFridayDay.setText("0");
        pnlFriday.add(txtFridayDay);

        add(pnlFriday);

        pnlSaturday.setBackground(new java.awt.Color(47, 43, 67));
        pnlSaturday.setArc(25);
        pnlSaturday.setColumnConstraints("center");
        pnlSaturday.setComponentConstraint(new String[] {});
        pnlSaturday.setFlatClientProperty("arc: 20;");
        pnlSaturday.setLayoutConstraints("wrap, center");
        pnlSaturday.setMinimumSize(new java.awt.Dimension(40, 40));
        pnlSaturday.setOpacity(0.0F);
        pnlSaturday.setOpaque(false);
        pnlSaturday.setPreferredSize(new java.awt.Dimension(40, 40));
        pnlSaturday.setRowConstraints("[]0[]");

        txtSaturday.setFont(new java.awt.Font("Inter Medium", 0, 9)); // NOI18N
        txtSaturday.setForeground(new java.awt.Color(38, 38, 38));
        txtSaturday.setText("Sat");
        pnlSaturday.add(txtSaturday);

        txtSaturdayDay.setFont(new java.awt.Font("Inter", 1, 11)); // NOI18N
        txtSaturdayDay.setForeground(new java.awt.Color(38, 38, 38));
        txtSaturdayDay.setText("0");
        pnlSaturday.add(txtSaturdayDay);

        add(pnlSaturday);
    }// </editor-fold>//GEN-END:initComponents
     // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JLabel monthYear;
    private ui.custom.SimplePanel pnlFriday;
    private ui.custom.SimplePanel pnlMonday;
    private ui.custom.SimplePanel pnlSaturday;
    private ui.custom.SimplePanel pnlSunday;
    private ui.custom.SimplePanel pnlThursday;
    private ui.custom.SimplePanel pnlTuesday;
    private ui.custom.SimplePanel pnlWednesday;
    private javax.swing.JLabel txtFriday;
    private javax.swing.JLabel txtFridayDay;
    private javax.swing.JLabel txtMonday;
    private javax.swing.JLabel txtMondayDay;
    private javax.swing.JLabel txtSaturday;
    private javax.swing.JLabel txtSaturdayDay;
    private javax.swing.JLabel txtSunday;
    private javax.swing.JLabel txtSundayDay;
    private javax.swing.JLabel txtThursday;
    private javax.swing.JLabel txtThursdayDay;
    private javax.swing.JLabel txtTuesday;
    private javax.swing.JLabel txtTuesdayDay;
    private javax.swing.JLabel txtWednesday;
    private javax.swing.JLabel txtWednesdayDay;
    // End of variables declaration//GEN-END:variables
}
