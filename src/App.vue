<template>
  <div id="app">
    <div class="top-bar">
      <el-select
          v-model="empId"
          placeholder="請選擇員工"
          style="width: 240px;"
          filterable
      >
        <el-option
            v-for="emp in employees"
            :key="emp.empId"
            :label="emp.name + '（員編:' + emp.empId + '）'"
            :value="emp.empId"
        />
      </el-select>
    </div>
    <SeatGrid :emp-id="empId" />
  </div>
</template>

<style scoped>
.top-bar {
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 28px 0 32px 0;
}
</style>

<script>
import SeatGrid from './components/SeatGrid.vue'
import axios from 'axios'
import { BASE_URL } from './api/seatApi';

export default {
  name: 'App',
  components: { SeatGrid },
  data() {
    return {
      empId: '',
      employees: []
    }
  },
  mounted() {
    axios.get(`${BASE_URL}/api/seats/employee`)
        .then(res => {
          this.employees = res.data;
        });
  }
}
</script>