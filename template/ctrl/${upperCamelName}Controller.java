package ${config.java.package.ctrl}.${table.prefix};

import ${config.java.package.base}.controller.BaseController;
import ${config.java.package.base}.core.response.ResponseData;
import ${config.java.package.base}.core.response.ResponseDataUtil;
import ${config.java.package.base}.core.utils.ParamsBuilder;
import ${config.java.package.base}.dao.Pagination;
import ${config.java.package.service}.${table.prefix}.${table.upperCamelName}Service;
import ${config.java.package.vo}.${table.prefix}.MemberVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RequestMapping("/api/v1/${table.tableName}s")
@RestController
public class ${table.upperCamelName}Controller extends BaseController {


    @GetMapping("{id}")
    @ApiOperation(value = "查询")
    public ResponseData get(@PathVariable Long id) throws Exception {
        ParamsBuilder paramsBuilder = ParamsBuilder.newBuild();
        ${table.upperCamelName}VO ${table.lowerCamelName}VO = this.${table.lowerCamelName}Service.get(paramsBuilder.build());
        return ResponseDataUtil.buildSuccess(${table.lowerCamelName}VO);
    }

    @GetMapping("")
    @ApiOperation(value = "搜索")
    public ResponseData search(HttpServletRequest request) throws Exception {
        ParamsBuilder paramsBuilder = ParamsBuilder.newBuild();
        Pagination pagination = super.buildPage(request);
        pagination.setParams(paramsBuilder.build());
        List<${table.upperCamelName}VO> ${table.lowerCamelName}VOList = this.${table.lowerCamelName}Service.queryForPage(pagination);
        return ResponseDataUtil.buildSuccess(${table.lowerCamelName}VOList);
    }

    @PostMapping("")
    @ApiOperation(value = "创建")
    public ResponseData create(${table.upperCamelName}VO ${table.lowerCamelName}VO) throws Exception {
        this.${table.lowerCamelName}Service.create(${table.lowerCamelName}VO);
        return ResponseDataUtil.buildSuccess();
    }

    @PatchMapping("{id}")
    @ApiOperation(value = "修改")
    public ResponseData create(@PathVariable Long id, ${table.upperCamelName}VO ${table.lowerCamelName}VO) throws Exception {
        ${table.lowerCamelName}VO.setId(id);
        this.${table.lowerCamelName}Service.update(${table.lowerCamelName}VO);
        return ResponseDataUtil.buildSuccess();
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除")
    public ResponseData delete(@PathVariable Long id) throws Exception {
        ${table.upperCamelName}VO ${table.lowerCamelName}VO = new ${table.upperCamelName}VO();
        ${table.lowerCamelName}VO.setId(id);
        this.${table.lowerCamelName}Service.delete(${table.lowerCamelName}VO);
        return ResponseDataUtil.buildSuccess();
    }

    @Autowired
    private ${table.upperCamelName}Service ${table.lowerCamelName}Service;
}
