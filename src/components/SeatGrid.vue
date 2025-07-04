<template>
  <div class="seat-outer">
    <div class="seat-container">
      <div v-for="floor in floors" :key="floor" class="floor-row">
        <div
            v-for="seat in seatsByFloor(floor)"
            :key="seat.floorSeatSeq"
            class="seat-card"
            :class="seatClass(seat)"
            @click="onSeatClick(seat)"
        >
          <span>
            {{ seat.floorNo }}樓: 座位{{ seat.seatNo }}
            <template v-if="seat.empId">
              【員編: {{ seat.empId }}】
            </template>
          </span>
        </div>
      </div>
    </div>

    <div class="legend-block">
      <div class="legend-row">
        <span class="legend-box empty"></span>空位
      </div>
      <div class="legend-row">
        <span class="legend-box occupied"></span>已佔用
      </div>
      <div class="legend-row">
        <span class="legend-box selected"></span>請選擇
      </div>
      <el-button
          class="legend-submit"
          type="primary"
          size="small"
          :disabled="!selectedSeat"
          @click="submitSeat"
      >送出</el-button>
    </div>
  </div>
</template>

<script>
import { fetchSeats, assignSeat } from '../api/seatApi'

export default {
  name: 'SeatGrid',
  props: ['empId'],
  data() {
    return {
      seats: [],
      selectedSeat: null,
    }
  },
  computed: {
    floors() {
      return [...new Set(this.seats.map(seat => seat.floorNo))];
    }
  },
  methods: {
    async loadSeats() {
      const res = await fetchSeats();
      this.seats = res.data;
    },
    seatsByFloor(floor) {
      return this.seats.filter(seat => seat.floorNo === floor);
    },
    seatClass(seat) {
      if (this.selectedSeat && this.selectedSeat.floorSeatSeq === seat.floorSeatSeq) {
        return 'selected';
      }
      if (seat.empId) {
        return 'occupied';
      }
      return 'empty';
    },
    onSeatClick(seat) {
      if (seat.empId) return;
      this.selectedSeat = seat;
    },
    async submitSeat() {
      if (!this.empId || !this.selectedSeat) return;
      await assignSeat(this.empId, this.selectedSeat.floorSeatSeq);
      this.selectedSeat = null;
      await this.loadSeats();
    }
  },
  mounted() {
    this.loadSeats();
  }
}
</script>

<style scoped>
.seat-outer {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.seat-container {
  margin: 0 auto 16px auto;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.floor-row {
  display: flex;
  justify-content: center;
  margin-bottom: 12px;
}

.seat-card {
  width: 220px;
  height: 40px;
  margin-right: 12px;
  margin-bottom: 4px;
  border-radius: 6px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: bold;
  font-size: 15px;
  text-align: center;
  cursor: pointer;
  box-shadow: 0 2px 6px rgba(0,0,0,0.04);
  transition: background 0.2s;
}
.seat-card:last-child {
  margin-right: 0;
}
.seat-card.empty {
  background: #F2F6FC;
  color: #222;
}
.seat-card.occupied {
  background: #e60000;
  color: #fff;
}
.seat-card.selected {
  background: #40FF83;
  color: #222;
}

.legend-block {
  margin-top: 20px;
  margin-bottom: 0;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  width: 140px;
}

.legend-row {
  display: flex;
  align-items: center;
  margin: 6px 0;
  font-size: 15px;
  font-weight: bold;
  justify-content: flex-start;
}

.legend-box {
  display: inline-block;
  width: 22px;
  height: 22px;
  border-radius: 4px;
  margin-right: 8px;
  vertical-align: middle;
}
.legend-box.empty { background: #F2F6FC; border: 1px solid #ccc; }
.legend-box.occupied { background: #e60000; }
.legend-box.selected { background: #40FF83; }

.legend-submit {
  width: 100%;
  margin-top: 8px;
  font-size: 15px;
  font-weight: bold;
  letter-spacing: 2px;
  display: block;
}
</style>
