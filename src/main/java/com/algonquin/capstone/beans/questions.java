package com.algonquin.capstone.beans;
import java.sql.Date;
import java.util.Calendar;
import java.util.UUID;

public class questions {
    protected UUID id;
    protected String question, option1, option2,option3,option4,answer,topic;
    protected Date date;
    
    public questions(String question,String option1,String option2,String option3,String option4,String answer, String topic ) {
	this.id = UUID.randomUUID();
	Calendar calendar = Calendar.getInstance();
	java.util.Date now = calendar.getTime();
	this.date = new Date(now.getTime());
	this.question = question;
	this.option1 = option1;
	this.option2 = option2;
	this.option3 = option3;
	this.option4 = option4;
	this.answer = answer;
	this.topic = topic;
}

    public questions(UUID id,String question,String option1,String option2, String option3,String option4,String answer,String topic,Date date) {
    	this.id=id;
    	this.question = question;
    	this.option1 = option1;
    	this.option2 = option2;
    	this.option3 = option3;
    	this.option4 = option4;
    	this.answer = answer;
    	this.topic = topic;
    	this.date=date;
    }
    
    
    public String getId() {
    	return id.toString();
    }
    
    public String getQuestion() {
    	return question;
    }
    
    public String getOption1() {
    	return option1;
    }
    
    public String getOption2() {
    	return option2;
    }
    public String getOption3() {
    	return option3;
    }
    public String getOption4() {
    	return option4;
    }
    public String getTopic() {
    	return topic;
    }
    public String getAnswer() {
    	return answer;
    }
    
    public Date getDate() {
    	return date;
    }
    
}
