package com.example.bean;

import java.util.List;

/**
 * Created by cuiha on 2018/3/23.
 */

public class User {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-03-23","title":"为什么连战乱中的利比亚人民都比你幸福？ | 美好新品","description":"吴晓波频道","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62879411.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MzA3OTM5NTkxNA==&idx=4&mid=2652445991&sn=d36eb77008d9c7b49675fd674219afda"},{"ctime":"2018-03-23","title":"一个女人的最高品味，看她的男人就知道","description":"慈怀读书会","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62805608.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5NzMyODA2MQ==&idx=5&mid=2651721172&sn=9984c06e23a39b53375e16f6a3237c51"},{"ctime":"2018-03-23","title":"别迷抖抖抖音了，那不过是城里的一台土味挖掘机！","description":"新周刊","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62862537.static/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5ODMzMDMyMw==&idx=1&mid=2653187200&sn=72fbeb34903b2e85e72fa948072c06ef"},{"ctime":"2018-03-23","title":"男子给女友微信转账10000元，女友却说没收到过钱！怎么回事？","description":"广州日报","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-45262906.static/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5MjA0MDk2MA==&idx=5&mid=2652421234&sn=363df8ff4be8cd76281c53f064f25e7d"},{"ctime":"2018-03-23","title":"太有才了！这些老师的日常评语，竟让无数网友点赞！把一件小事做到极致可真酷 | 特别关注","description":"中国教育报","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62730724.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5OTU5MzcyMg==&idx=1&mid=2653181617&sn=eb43ee3ba65e9bb90e21039df394c4d9"},{"ctime":"2018-03-23","title":"新零售概念板块逆势大涨逾5% 两大巨头阵型初现，今年主战场确定在这？","description":"东方财富网","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62879358.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MzA5NDMxMzQxMA==&idx=5&mid=2651571310&sn=f28ba46804de233be518eeda1f16fe6f"},{"ctime":"2018-03-23","title":"前公司喊我回去，我该怎么办？| 每周一问","description":"智联招聘","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62879351.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5OTE1NDQwMA==&idx=1&mid=2653351506&sn=ca12884af01a851da2f142160af01fcb"},{"ctime":"2018-03-23","title":"4S店最不想让你知道的10个秘密","description":"中国新闻周刊","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62500246.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5MDU1Mzg3Mw==&idx=4&mid=2651211524&sn=b679edbe754bb1b2b1575c860f0b4b38"},{"ctime":"2018-03-23","title":"想要宝宝英语比自己好，几岁开始很重要","description":"年糕妈妈","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62879304.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MzA5OTk2NjYwMg==&idx=4&mid=2657741104&sn=162141b3ff4fa40d63f99437a1b5227c"},{"ctime":"2018-03-23","title":"\u201c网贷者\u201d之死：25岁理工硕士旅店楼顶自缢始末","description":"腾讯科技","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62879293.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=Mjc1NjM3MjY2MA==&idx=2&mid=2691336646&sn=5e016bbe20be089e87f88c5845486ca5"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2018-03-23
         * title : 为什么连战乱中的利比亚人民都比你幸福？ | 美好新品
         * description : 吴晓波频道
         * picUrl : https://zxpic.gtimg.com/infonew/0/wechat_pics_-62879411.jpg/640
         * url : https://mp.weixin.qq.com/s?__biz=MzA3OTM5NTkxNA==&idx=4&mid=2652445991&sn=d36eb77008d9c7b49675fd674219afda
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
