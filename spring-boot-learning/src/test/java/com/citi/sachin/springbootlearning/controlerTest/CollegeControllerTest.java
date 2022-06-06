package com.citi.sachin.springbootlearning.controlerTest;

import com.citi.sachin.springbootlearning.controllers.CollegeController;
import com.citi.sachin.springbootlearning.domain.entity.College;
import com.citi.sachin.springbootlearning.domain.repository.CollegeRepository;
import com.citi.sachin.springbootlearning.service.CollegeService;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CollegeControllerTest {


    @InjectMocks
    CollegeController collegeController;
    @Mock
    CollegeService  collegeService;



    @Mock
    CollegeRepository  collegeRepository;


   private College  college;

   College college1 = new College(1l,"sae","pune",9l);
    College college2 = new College(2l,"JSPM","usmanabad",8l);
    College college3 = new College(3l,"pict","hinjewadi",10l);


    @BeforeEach
    public void starts()
    {
        MockitoAnnotations.openMocks(this);
    }
@AfterEach
    public void ends()
{
    college1=null;
    college2=null;
    college3 = null;

}

@Test
    public  void saveCollgeTest() throws Exception {
   //     List<College> list = new ArrayList<>(Arrays.asList(college1,college2,college3));
         this.collegeService.collegeRepository=this.collegeRepository;
 //   Mockito.nullable(CollegeController.class);
        Mockito.when(this.collegeService.collegeRepository.save(college1)).thenReturn(college1);
        this.collegeController.saveCollege(List.of(college1));
        assertEquals(college1.getCollegeAdress(),"pune");
       // Mockito.verify(this.collegeController.saveCollege(college1));
      //  Mockito.doReturn(college4);
      //  Mockito.clearAllCaches();

    }




}
