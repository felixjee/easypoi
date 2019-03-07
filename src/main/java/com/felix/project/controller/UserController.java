package com.felix.project.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.felix.project.model.User;
import com.felix.project.repository.UserDao;
import com.felix.project.util.ExportxUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/export")
    public void exports(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> list = userDao.findAll();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息", "学生"), User.class, list);
        ExportxUtil.export(response, workbook, "用户信息");
    }

    @PostMapping(value = "/import")
    @ResponseBody
    public List<User> importxls(@RequestParam("file") MultipartFile file, Model model) throws Exception {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        List<User> result = ExcelImportUtil.importExcel(file.getInputStream(),User.class, params);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getUserName());
            System.out.println(result.get(i).getEmail());
        }
        return result;
    }
}

