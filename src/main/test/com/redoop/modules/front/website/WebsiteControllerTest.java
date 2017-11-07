package com.redoop.modules.front.website;

import com.redoop.RedoopApplication;
import com.redoop.modules.admin.download.entity.Download;
import com.redoop.modules.admin.download.service.DownloadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/11/7.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedoopApplication.class)
public class WebsiteControllerTest {

    @Autowired
    private DownloadService downloadService;


    @Test
    public void addDocumenCount() throws Exception {
        String id = "40285c815f9586fa015f9589529e0001";

        Download download = downloadService.findMarkDownId(id);

        System.out.println(download);

    }

}