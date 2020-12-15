package ${config.java.package.ctrl}.${table.prefix};

import ${config.java.package.base}.controller.BaseController;
import ${config.java.package.base}.bo.${table.prefix}.${table.upperCamelName}BO;
import ${config.java.package.base}.core.response.ResponseData;
import ${config.java.package.base}.core.response.ResponseDataUtil;
import ${config.java.package.base}.core.utils.ParamsBuilder;
import ${config.java.package.base}.dao.Pagination;
import ${config.java.package.service}.${table.prefix}.${table.upperCamelName}Service;
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
        paramsBuilder.addParam("id",id);
        ${table.upperCamelName}BO ${table.lowerCamelName}BO = this.${table.lowerCamelName}Service.get(paramsBuilder.build());
        return ResponseDataUtil.buildSuccess(${table.lowerCamelName}BO);
    }

    @GetMapping("")
    @ApiOperation(value = "搜索")
    public ResponseData search(HttpServletRequest request,
                                @RequestParam(required = false) String pi,
                                @RequestParam(required = false) String ps
        ) throws Exception {
        ParamsBuilder paramsBuilder = ParamsBuilder.newBuild();
        if (pi != null && ps != null){
        Pagination pagination=super.buildPage(request);
        pagination.setParams(paramsBuilder.build());
        List<${table.upperCamelName}BO>${table.lowerCamelName}BOList=this.${table.lowerCamelName}Service.queryForPage(pagination);
        return ResponseDataUtil.buildSuccess(${table.lowerCamelName}BOList,pagination);
        }else{
        List<${table.upperCamelName}BO>${table.lowerCamelName}BOList=this.${table.lowerCamelName}Service.query(paramsBuilder.build());
        return ResponseDataUtil.buildSuccess(${table.lowerCamelName}BOList);
        }
    }

    @PostMapping("")
    @ApiOperation(value = "创建")
    public ResponseData create(@RequestBody ${table.upperCamelName}BO ${table.lowerCamelName}BO) throws Exception {
        super.setCreatedInfo(${table.lowerCamelName}BO);
        this.${table.lowerCamelName}Service.create(${table.lowerCamelName}BO);
        return ResponseDataUtil.buildSuccess();
    }

    @PatchMapping("{id}")
    @ApiOperation(value = "修改")
    public ResponseData create(@PathVariable Long id, @RequestBody ${table.upperCamelName}BO ${table.lowerCamelName}BO) throws Exception {
        ${table.lowerCamelName}BO.setId(id);
        super.setModifiedInfo(${table.lowerCamelName}BO);
        this.${table.lowerCamelName}Service.update(${table.lowerCamelName}BO);
        return ResponseDataUtil.buildSuccess();
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除")
    public ResponseData delete(@PathVariable Long id) throws Exception {
        ${table.upperCamelName}BO ${table.lowerCamelName}BO = new ${table.upperCamelName}BO();
        ${table.lowerCamelName}BO.setId(id);
        super.setModifiedInfo(${table.lowerCamelName}BO);
        this.${table.lowerCamelName}Service.delete(${table.lowerCamelName}BO);
        return ResponseDataUtil.buildSuccess();
    }

    @Autowired
    private ${table.upperCamelName}Service ${table.lowerCamelName}Service;
}
