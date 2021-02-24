package com.xiaoyc.remind.service.impl;

import com.xiaoyc.remind.pojo.vo.FreeSMSInfoListVO;
import com.xiaoyc.remind.pojo.vo.FreeSMSListVO;
import com.xiaoyc.remind.service.FreeSMSService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoyc
 * @date 2021/2/24 15:58
 */
@Service
public class FreeSMSImpl implements FreeSMSService {

    /**
     * @description 免费短信列表
     *
     * @params []
     * @return java.util.List<com.xiaoyc.remind.pojo.vo.FreeSMSListVO>
     * @author xiaoyc
     * @date 2021/2/24 0024 16:10
     **/
    @Override
    public List<FreeSMSListVO> smsList() throws IOException {
        List<FreeSMSListVO> resultList = new LinkedList<>();
        final String url = "http://www.z-sms.com/";
        Document document = Jsoup.connect(url).get();
        Elements formElement = document.getElementsByClass("col-md-4");
        formElement.forEach(x -> {
            String src = x.getElementsByTag("img").attr("src");
            String content = x.getElementsByClass("number").text().replace("复制", "");
            String number = x.getElementsByClass("btnCopy").text().replace("复制", "");
            FreeSMSListVO vo = new FreeSMSListVO();
            vo.setImageUrl(src);
            vo.setContent(content);
            vo.setNumber(number);
            resultList.add(vo);
        });
        return resultList;
    }

    /**
     * @description 短信内容列表
     *
     * @params []
     * @return java.util.List<com.xiaoyc.remind.pojo.vo.FreeSMSInfoListVO>
     * @author xiaoyc
     * @date 2021/2/24 0024 16:14
     **/
    @Override
    public List<FreeSMSInfoListVO> smsInfoList(String number) throws IOException {
        List<FreeSMSInfoListVO> resultList = new LinkedList<>();
        final String url = "http://www.z-sms.com/sms-receive-free.php?pho_num=" + number;
        Document document = Jsoup.connect(url).get();
        Elements formElement = document.getElementsByClass("smsContent");
        Map<Integer, String> titleMap = new HashMap<>();
        formElement.forEach(x -> {
            Elements title = x.getElementsByClass("title");
            for (int i = 0; i < title.size(); i++) {
                String first = title.get(i).getElementsByTag("span").first().text();
                String last = title.get(i).getElementsByTag("span").last().text();
                String res = first + " 来自：" + last;
                titleMap.put(i, res);
            }
            Elements conters = x.getElementsByClass("conters");
            for (int i = 0; i < conters.size(); i++) {
                FreeSMSInfoListVO vo = new FreeSMSInfoListVO();
                String span1 = conters.get(i).select("span").html();
                span1 = span1.replace("alt=\"(更多号码 www.z-sms.com )\"", "");
                vo.setFrom(titleMap.get(i));
                vo.setContent(span1);
                resultList.add(vo);
            }
        });
        return resultList;
    }

}
