package com.kingbin.controller;

import com.kingbin.model.ResultModel;
import com.kingbin.model.ResultTools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/*****
 * 文件上传
 */

@RestController
public class FileController {

    /**
     * 提取上传方法为公共方法
     *
     * @param uploadDir 上传文件目录
     * @param file      上传对象
     * @throws Exception
     */
    private String executeUpload(String uploadDir, MultipartFile file) throws Exception {
        // String uploadFilePath = file.getOriginalFilename();
        // // 文件后缀名
        // String suffix =
        // file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        // // 上传文件名
        // String fileName = uploadFilePath.substring(uploadFilePath.lastIndexOf('\\') +
        // 1, uploadFilePath.indexOf('.'))+ suffix;

        /**
         * 根据时间给文件命名 防止重复
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String strDate = sdf.format(date);
        String fileName = strDate + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."),
                file.getOriginalFilename().length());
        // 服务器端保存的文件对象
        File serverFile = new File(uploadDir + fileName);
        // 将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
        return fileName;
    }

    /**
     * 上传文件方法
     *
     * @param file 前台上传的文件对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResultModel upload(HttpServletRequest request, MultipartFile file) {
        String fileName = "";
        try {
            if (file == null) {// 未传文件
                return ResultTools.result(1004, "", null);
            }
            // 上传目录地址 src/main/webapp/
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            // 如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            System.out.println(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            // 调用上传方法
            fileName = "http://localhost:8080/upload/" + executeUpload(uploadDir, file);
        } catch (Exception e) {
            // 打印错误堆栈信息
            e.printStackTrace();
            return ResultTools.result(1, "imgurl", null);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("img", fileName);
        return ResultTools.result(0, "imgurl", map);
    }

    /**
     * 上传多个文件
     *
     * @param request 请求对象
     * @param file    上传文件集合
     * @return
     */
    @RequestMapping(value = "/uploads", method = RequestMethod.POST)
    public ResultModel uploads(HttpServletRequest request, MultipartFile[] file) {
        List<String> imgLs = new ArrayList<String>();
        try {
            if (file == null) {// 未传文件
                return ResultTools.result(1004, "", null);
            }
            // 上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            // 如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            // 遍历文件数组执行上传
            for (int i = 0; i < file.length; i++) {
                if (file[i] != null) {
                    // 调用上传方法
                    imgLs.add("http://localhost:8080/upload/" + executeUpload(uploadDir, file[i]));
                }
            }
        } catch (Exception e) {
            // 打印错误堆栈信息
            e.printStackTrace();
            return ResultTools.result(1, "imgurl", null);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("img", imgLs);
        return ResultTools.result(0, "imgurl", map);
    }

}
