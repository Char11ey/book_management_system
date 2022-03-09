package servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author Charley
 * @creat 2021-07-07 16:10
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取下载文件名
        String fileName = "头像.jpg";
        //获取servlet对象
        ServletContext servletContext = getServletContext();
        //Content-Disposition表示收到的数据怎样处理
        //attachment表示附件
        if(req.getHeader("User-Agent").contains("FireFox")){
            // 使用下面的格式进行 BASE64 编码后
            String str = "attachment; fileName=" + "=?utf-8?B?"
                    + new BASE64Encoder().encode("中文.jpg".getBytes(StandardCharsets.UTF_8)) + "?=";
            // 设置到响应头中
            resp.setHeader("Content-Disposition", str);
        }else {
            String str = "attachment; fileName=" + URLEncoder.encode(fileName,"UTF-8");
            resp.setHeader("Content-Disposition",str);
        }
        //获取文件类型
        String mimeType = servletContext.getMimeType("/file/" + fileName);
        System.out.println("下载的文件类型："+mimeType);
        //告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + fileName);
        OutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(resourceAsStream, outputStream);

    }
}
