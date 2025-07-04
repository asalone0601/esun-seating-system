import axios from 'axios';

export const BASE_URL = 'http://192.168.1.127:8080';

export function fetchSeats() {
    return axios.get(`${BASE_URL}/api/seats`);
}

export function assignSeat(empId, seatSeq) {
    return axios.post(`${BASE_URL}/api/seats/assign`, null, {
        params: { empId, seatSeq }
    });
}
