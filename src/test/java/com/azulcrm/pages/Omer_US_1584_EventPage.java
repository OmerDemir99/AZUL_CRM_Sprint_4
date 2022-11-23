package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Omer_US_1584_EventPage {

    public Omer_US_1584_EventPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//div[@id='feed-add-post-form-tab']/span/span)[1]")
    WebElement message;

    @FindBy(xpath = "(//div[@id='feed-add-post-form-tab']/span/span)[2]")
    WebElement task;

    @FindBy(xpath = "(//div[@id='feed-add-post-form-tab']/span/span)[3]")
    WebElement event;

    @FindBy(xpath = "(//div[@id='feed-add-post-form-tab']/span/span)[4]")
    WebElement poll;

    @FindBy(xpath = "(//div[@id='feed-add-post-form-tab']/span/span)[5]")
    WebElement more;

    public void clickMicroBlog(String microBlogName) {
        List<WebElement> microBlog = new ArrayList<>(Arrays.asList(message,task,event,poll,more));

            for (WebElement element : microBlog) {
                if (element.getText().equals(microBlogName)){
                element.click();
                }
            }
    }

    @FindBy(xpath = "//input[@placeholder='Event name']")
    public WebElement eventNameInputBox;

    @FindBy(xpath = "//body[@style='min-height: 70px;']")
    public WebElement eventMessageInputBox;

    @FindBy(id = "feed-cal-event-fromcal_3Jcl" )
    public WebElement startDate;

    @FindBy(xpath = "(//input[@class='calendar-inp calendar-inp-cal'])[1]")
    public WebElement startDate2;

    @FindBy(id = "feed-cal-event-tocal_3Jcl" )
    public WebElement endDate;

    @FindBy(id = "feed_cal_event_from_timecal_3Jcl")
    public WebElement startTime;

    @FindBy (id = "feed_cal_event_to_timecal_3Jcl")
    public WebElement endTime;

    @FindBy(id = "event-full-daycal_3Jcl")
    public WebElement allDayButton;



    @FindBy(id = "event-remindercal_3Jcl")
    public WebElement setReminderButton;

    @FindBy(id = "event-remind_countcal_3Jcl")
    public WebElement remindCounter;

    @FindBy(id = "event-remind_typecal_3Jcl")
    public WebElement reminderOptions;



    @FindBy(xpath = "//a[@class='bx-calendar-left-arrow']")
    public WebElement calenderLeftArrow;

    @FindBy(xpath = "//a[@class='bx-calendar-right-arrow']")
    public WebElement calenderRightArrow;

    @FindBy(xpath = "//span[@class='bx-calendar-header-content']//a[@class='bx-calendar-top-month']")
    public WebElement topMonth;

    @FindBy(xpath = "//a[@class='bx-calendar-top-year']")
    public WebElement topYear;

    @FindBy(xpath = "//span[@class='bx-calendar-month']")
    public List<WebElement> monthContents;

    @FindBy(xpath = "//span[@class='bx-calendar-month bx-calendar-month-active']")
    public WebElement activeMonth;

    @FindBy(xpath = "//span[@class='bx-calendar-year-number']")
    public List<WebElement> yearContents;

    @FindBy(xpath = "//span[@class='bx-calendar-year-number bx-calendar-year-active']")
    public WebElement activeYear;

    @FindBy(xpath = "//input[@class='bx-calendar-year-input']")
    public WebElement yearInputBox;

    @FindBy(xpath = "//a[@class='bx-calendar-cell']")
    public List<WebElement> calenderCells;

    @FindBy(xpath = "//input[@class='bxc-cus-sel']")
    public List<WebElement> hourAndMinute;

    @FindBy(xpath = "//td[@title='Increase (Up)']")
    public List<WebElement> increaseUpButtons;

    @FindBy(xpath = "//td[@title='Decrease (Down)']")
    public List<WebElement> decreaseDownButtons;

    @FindBy(xpath = "//span[@class='bxc-am-pm']")
    public WebElement amAndPmOptions;

    @FindBy(xpath = "//input[@value='Set Time']")
    public List<WebElement> setTimeButtons;

    @FindBy(xpath = "//img[@title='Close']")
    public List<WebElement> close;



    @FindBy(xpath = "//div/a/span[@class='calendar-item-date']")
    public WebElement upcomingEvents;

    @FindBy(xpath = "//span[@class='calendar-slider-sidebar-remind-warning-name']")
    public WebElement reminderText; // for zero(minutes) ==> When event starts

    @FindBy(id = "calendar_view_slider_271982_time_inner_wrap")
    public WebElement calenderSlideBar;

    @FindBy(id = "calendar_view_slider_90418_but_del")
    public WebElement deleteButton;

    @FindBy(xpath = "(//span[@class='menu-item-link-text'])[1]")
    public WebElement activityStreamButton;



    @FindBy(xpath = "//span[.='Specify time zone']")
    public WebElement specifyTimeZoneButton;

    @FindBy(xpath = "//span[.='Hide time zone']")
    public WebElement hideTimeZoneButton;

    @FindBy(id = "feed-cal-tz-fromcal_3Jcl")
    public WebElement timeZoneStart;

    @FindBy(id = "feed-cal-tz-tocal_3Jcl")
    public WebElement timeZoneEnd;

    @FindBy(xpath = "//div[@class='bx-panel-tooltip-text']/span" )
    public WebElement questionMark;


    @FindBy(id = "event-locationcal_3Jcl")
    public WebElement selectingMeetingRoomButton;

    @FindBy(id = "bxecmr_0")
    public WebElement centralMeetingRoom;

    @FindBy(id = "bxecmr_1")
    public WebElement eastMeetingRoom;

    @FindBy(id = "bxecmr_2")
    public WebElement westMeetingRoom;

    @FindBy(xpath = "//div[@class='calendar-slider-detail-place-name']")
    public WebElement meetingRoomLocationName;



    @FindBy(id = "feed-event-dest-cont")
    public WebElement addPersonsInputBox;

    @FindBy(xpath = "//div[.='To all employees']")
    public WebElement toAllEmployees;

    @FindBy(id = "destDepartmentTab_calnAJEM3")
    public WebElement employeesAndDepartment;

    @FindBy(xpath = "//div[@class='bx-finder-company-department-text']")
    public List<WebElement> departments;

    @FindBy(xpath = "//div[.='All department and subdepartment employees']")
    public List<WebElement> allDepartment;

    @FindBy(xpath = "//span[@id='feed-event-dest-item']//span[@class='feed-event-destination-text']")
    public List<WebElement> addedMembers;

    @FindBy(xpath = "//span[@class='feed-event-del-but']")
    public List<WebElement> deleteMembers;

    @FindBy(xpath = "//div[@class='bx-finder-box-item-t7-name']")
    public List<WebElement> peopleFromList;



    @FindBy(xpath = "//div[@class='calendar-planner-timeline-selector']")
    public WebElement timeLineSelector;

    @FindBy(xpath = "//span[@data-bx-planner-meta='selector-resize-right']")
    public WebElement timeLineResizer;

    @FindBy(xpath = "//div[@class='calendar-planner-selector-notice']")
    public WebElement establishedTime;

    @FindBy(xpath = "//div[@class='calendar-planner-timeline-wrapper']")
    public WebElement timeLineWrapper;

    @FindBy(xpath = "//span[@class='calendar-planner-users-item']")
    public WebElement attendees;

    @FindBy(xpath = "(//div[@class='sidebar-widget-top-title'])[2]")
    public WebElement popularPosts;

    @FindBy(xpath = "//span[@class='popup-window-close-icon']")
    public WebElement closeButtonForAddMembers;



    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(id = "blog-submit-button-cancel")
    public WebElement cancelButton;



    @FindBy(xpath = "//span[@class='feed-event-more-link-text']")
    public List<WebElement> moreAndHideButtons;


    @FindBy(xpath = "//div[@class='feed-event-grey-cont']")
    public WebElement greyContent;




    public void jsAlertAccept(){
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }


    public void iframeChanger (int order) {
        Driver.getDriver().switchTo().frame(order);
    }

    public void parentIframe() {
        Driver.getDriver().switchTo().parentFrame();
    }

    public String currentDay(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = formatter.format(date);

        return currentDate;
    }


    public void selectOption(WebElement selectOption, String value) {
        Select select = new Select(selectOption);
        // int sizeOfSelectOptions = select.getOptions().size();

        select.selectByVisibleText(value);
        Assert.assertEquals(value, select.getFirstSelectedOption().getText());
    }

    public void selectOption(WebElement selectOption, int index, String expectedTimeZone) {
        Select select = new Select(selectOption);
        // int sizeOfSelectOptions = select.getOptions().size();

        select.selectByIndex(index);
        Assert.assertEquals(expectedTimeZone, select.getFirstSelectedOption().getText());
    }

    public void deleteEvent(){

    }



    public static void main(String[] args) {


       String aa = "2022";
       Integer xx = Integer.valueOf(aa)-1;
        System.out.println(xx);
        String qq = String.valueOf(xx);
        System.out.println(qq);

        Integer gizem = 232;
        System.out.println("gizem = " + gizem);

        Integer neslihan = 312;
        System.out.println("neslihan = " + neslihan);
    }





}
