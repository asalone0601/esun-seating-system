CREATE OR REPLACE PROCEDURE assign_seat(p_emp_id VARCHAR, p_seat_seq INT)
LANGUAGE plpgsql
AS $$
BEGIN
    IF EXISTS (SELECT 1 FROM Employee WHERE FLOOR_SEAT_SEQ = p_seat_seq) THEN
        RAISE EXCEPTION '此座位已被佔用';
    END IF;

    UPDATE Employee SET FLOOR_SEAT_SEQ = NULL WHERE EMP_ID = p_emp_id;
    UPDATE Employee SET FLOOR_SEAT_SEQ = p_seat_seq WHERE EMP_ID = p_emp_id;
END;
$$;

CREATE OR REPLACE PROCEDURE release_seat(p_emp_id VARCHAR)
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE Employee SET FLOOR_SEAT_SEQ = NULL WHERE EMP_ID = p_emp_id;
END;
$$;