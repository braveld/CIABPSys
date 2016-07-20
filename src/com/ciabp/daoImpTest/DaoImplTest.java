package com.ciabp.daoImpTest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.io.Resource;

import com.ciabp.daos.AdminDao;
import com.ciabp.daos.AnswerDao;
import com.ciabp.daos.NoteDao;
import com.ciabp.daos.NoteImageDao;
import com.ciabp.daos.QDetailDao;
import com.ciabp.daos.QuestionDao;
import com.ciabp.daos.QuestionaireDao;
import com.ciabp.daos.ReserveDao;
import com.ciabp.daos.UserDao;
import com.ciabp.daos.WriteQStatusDao;

import com.ciabp.models.Admin;
import com.ciabp.models.Answer;
import com.ciabp.models.Note;
import com.ciabp.models.NoteImage;
import com.ciabp.models.QDetail;
import com.ciabp.models.Question;
import com.ciabp.models.Questionaire;
import com.ciabp.models.Reserve;
import com.ciabp.models.User;
import com.ciabp.models.WriteQStatus;
import com.ciabp.services.AdminService;
import com.ciabp.services.NoteImageService;
import com.ciabp.services.NoteService;
import com.ciabp.services.QresultService;
import com.ciabp.services.QuestionService;
import com.ciabp.services.QuestionaireService;
import com.ciabp.services.SnoteService;
import com.ciabp.services.UserService;
import com.ciabp.services.WriteqstatusService;

public class DaoImplTest {
	public static void main(String[] args) {
		Resource rs = new FileSystemResource("D:/Program Files/CIABPSys/src/applicationContext.xml"); 
        BeanFactory factory = new XmlBeanFactory(rs);
            

        String filename = "ri/1233.txt";
        System.out.println(filename.split("\\.")[1]);
	}
}
