package ru.mipt.java2016.homework.g597.grishutin.task2;

import ru.mipt.java2016.homework.tests.task2.StudentKey;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.RandomAccessFile;

public class StudentKeySerializationStrategy implements SerializationStrategy<StudentKey> {
    private IntegerSerializer integerSerializer = IntegerSerializer.getInstance();
    private StringSerializer stringSerializer = StringSerializer.getInstance();

    @Override
    public void serialize(StudentKey studentKey, DataOutput raf) throws IOException {
        integerSerializer.serialize(studentKey.getGroupId(), raf);
        stringSerializer.serialize(studentKey.getName(), raf);
    }

    @Override
    public StudentKey deserialize(DataInput raf) throws IOException {
        return new StudentKey(integerSerializer.deserialize(raf),
                stringSerializer.deserialize(raf));
    }

    @Override
    public Long bytesSize(StudentKey value) {
        return integerSerializer.bytesSize(value.getGroupId()) +
                stringSerializer.bytesSize(value.getName());
    }
}
