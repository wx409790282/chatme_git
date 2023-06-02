<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="会话号" prop="sessionId">
        <el-input
          v-model="queryParams.sessionId"
          placeholder="请输入会话号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="问题序号" prop="seq">
        <el-input
          v-model="queryParams.seq"
          placeholder="请输入问题序号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提问" prop="questionFrom">
        <el-input
          v-model="queryParams.questionFrom"
          placeholder="请输入提问"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提问长度" prop="questionLength">
        <el-input
          v-model="queryParams.questionLength"
          placeholder="请输入提问长度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提问时间" prop="questionTime">
        <el-date-picker clearable
          v-model="queryParams.questionTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择提问时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="回答者" prop="answerFrom">
        <el-input
          v-model="queryParams.answerFrom"
          placeholder="请输入回答者"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="回答长度" prop="answerLength">
        <el-input
          v-model="queryParams.answerLength"
          placeholder="请输入回答长度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="回答时间" prop="answerTime">
        <el-date-picker clearable
          v-model="queryParams.answerTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择回答时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['chat:answer:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['chat:answer:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['chat:answer:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['chat:answer:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="answerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="用户" align="center" prop="userId" />
      <el-table-column label="会话号" align="center" prop="sessionId" />
      <el-table-column label="问题序号" align="center" prop="seq" />
      <el-table-column label="问题者" align="center" prop="question" />
      <el-table-column label="提问" align="center" prop="questionFrom" />
      <el-table-column label="提问长度" align="center" prop="questionLength" />
      <el-table-column label="提问时间" align="center" prop="questionTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.questionTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="回答者" align="center" prop="answerFrom" />
      <el-table-column label="回答" align="center" prop="answer" />
      <el-table-column label="回答长度" align="center" prop="answerLength" />
      <el-table-column label="回答时间" align="center" prop="answerTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.answerTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['chat:answer:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['chat:answer:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改问答对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户" />
        </el-form-item>
        <el-form-item label="会话号" prop="sessionId">
          <el-input v-model="form.sessionId" placeholder="请输入会话号" />
        </el-form-item>
        <el-form-item label="问题序号" prop="seq">
          <el-input v-model="form.seq" placeholder="请输入问题序号" />
        </el-form-item>
        <el-form-item label="问题者" prop="question">
          <el-input v-model="form.question" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="提问" prop="questionFrom">
          <el-input v-model="form.questionFrom" placeholder="请输入提问" />
        </el-form-item>
        <el-form-item label="提问长度" prop="questionLength">
          <el-input v-model="form.questionLength" placeholder="请输入提问长度" />
        </el-form-item>
        <el-form-item label="提问时间" prop="questionTime">
          <el-date-picker clearable
            v-model="form.questionTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择提问时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="回答者" prop="answerFrom">
          <el-input v-model="form.answerFrom" placeholder="请输入回答者" />
        </el-form-item>
        <el-form-item label="回答" prop="answer">
          <el-input v-model="form.answer" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="回答长度" prop="answerLength">
          <el-input v-model="form.answerLength" placeholder="请输入回答长度" />
        </el-form-item>
        <el-form-item label="回答时间" prop="answerTime">
          <el-date-picker clearable
            v-model="form.answerTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择回答时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listAnswer, getAnswer, delAnswer, addAnswer, updateAnswer } from "@/api/chat/answer";

export default {
  name: "Answer",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 问答表格数据
      answerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        sessionId: null,
        seq: null,
        question: null,
        questionFrom: null,
        questionLength: null,
        questionTime: null,
        answerFrom: null,
        answer: null,
        answerLength: null,
        answerTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "用户不能为空", trigger: "blur" }
        ],
        question: [
          { required: true, message: "问题者不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询问答列表 */
    getList() {
      this.loading = true;
      listAnswer(this.queryParams).then(response => {
        this.answerList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        userId: null,
        sessionId: null,
        seq: null,
        question: null,
        questionFrom: null,
        questionLength: null,
        questionTime: null,
        answerFrom: null,
        answer: null,
        answerLength: null,
        answerTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加问答";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAnswer(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改问答";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAnswer(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAnswer(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除问答编号为"' + ids + '"的数据项？').then(function() {
        return delAnswer(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('chat/answer/export', {
        ...this.queryParams
      }, `answer_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
