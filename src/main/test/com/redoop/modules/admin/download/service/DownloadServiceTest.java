package com.redoop.modules.admin.download.service;

import com.redoop.RedoopApplication;
import com.redoop.modules.admin.download.entity.Download;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.testng.Assert.*;

/**
 * Created by Administrator on 2017/11/7.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedoopApplication.class)
public class DownloadServiceTest {

    @Autowired
    private DownloadService downloadService;


    @Test
    public void testFindAll() throws Exception {
        downloadService.findAll(1);

    }

    @Test
    public void testFindById() throws Exception {

        Download download = downloadService.findById("40285c815f9586fa015f9588583a0000");

        System.out.println(download.toString());
    }





}