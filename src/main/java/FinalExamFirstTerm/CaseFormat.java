package FinalExamFirstTerm;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

enum CaseFormat {
    ORDINARY, UPPER_CASE, LOWER_CASE
}

enum Currency {
    AUD, BRL, CAD, CHF, DKK, EUR, PLN, SGD, TRY, USD, GBP, JPY
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface WriteFormat {
    CaseFormat format() default CaseFormat.ORDINARY;
}

class InvalidCastException extends RuntimeException {
    public InvalidCastException(String message) {
        super(message);
    }

    public InvalidCastException(String message, Throwable cause) {
        super(message, cause);
    }
}

class Job {
    private int year;
    @WriteFormat(format = CaseFormat.UPPER_CASE)
    private String jobTitle;
    private String category;
    @WriteFormat
    private Currency currency;
    private int salary;
    @WriteFormat(format = CaseFormat.UPPER_CASE)
    private String residence;
    @WriteFormat(format = CaseFormat.LOWER_CASE)
    private String experienceLevel;
    private String companyLocation;
    private String companySize;

    public Job (JobBuilder builder) {
        this.year = builder.year;
        this.jobTitle = builder.jobTitle;
        this.category = builder.category;
        this.currency = builder.currency;
        this.salary = builder.salary;
        this.residence = builder.residence;
        this.experienceLevel = builder.experienceLevel;
        this.companyLocation = builder.companyLocation;
        this.companySize = builder.companySize;
    }

    public int getYear() {
        return year;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCategory() {
        return category;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getSalary() {
        return salary;
    }

    public String getResidence() {
        return residence;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public String getCompanySize() {
        return companySize;
    }

    static class JobBuilder {
        private int year;
        private String jobTitle;
        private String category;
        private Currency currency;
        private int salary;
        private String residence;
        private String experienceLevel;
        private String companyLocation;
        private String companySize;

        public JobBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public JobBuilder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public JobBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        public JobBuilder setCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public JobBuilder setSalary(int salary) {
            this.salary = salary;
            return this;
        }

        public JobBuilder setResidence(String residence) {
            this.residence = residence;
            return this;
        }

        public JobBuilder setExperienceLevel(String experienceLevel) {
            this.experienceLevel = experienceLevel;
            return this;
        }

        public JobBuilder setCompanyLocation(String companyLocation) {
            this.companyLocation = companyLocation;
            return this;
        }

        public JobBuilder setCompanySize(String companySize) {
            this.companySize = companySize;
            return this;
        }

        public Job build() {
            return new Job(this);
        }
    }
}

class Final {
    private List<Job> jobs;
    private static String header;

    public Final(String filename) {
        jobs = readFile(filename);
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public static String getHeader() {
        return header;
    }

    public static List<Job> readFile(String filename) {
        List<Job> returnMe = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            List<String> lines = reader.lines().toList();
            header = lines.get(0);
            for (int i = 1; i < lines.size(); i++) {
                String[] separated = lines.get(i).split(",");
                if (separated[0].equals("") || separated[1].equals("") || separated[2].equals("")) {
                    throw new InvalidCastException("Essential fields missing bitch", new ClassCastException("Values are empty"));
                }
                Job job = new Job.JobBuilder()
                        .setYear(Integer.parseInt(separated[0]))
                        .setJobTitle(separated[1])
                        .setCategory(separated[2])
                        .setCurrency(Currency.valueOf(separated[3]))
                        .setSalary(Integer.parseInt(separated[4]))
                        .setResidence(separated[5])
                        .setExperienceLevel(separated[6])
                        .setCompanyLocation(separated[7])
                        .setCompanySize(separated[8])
                        .build();
                returnMe.add(job);
            }
            reader.close();
            return returnMe;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class CustomFileWrite {
    public static void writeReport(String outputFilename, List<Job> jobs) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename));
            Class<?> jobClass = Job.class;
            Field[] fieldsOfJobClass = jobClass.getDeclaredFields();
            writer.write(Final.getHeader().toUpperCase().concat("\n"));
            for (Job job : jobs) {
                String temp = "";
                for (Field field : fieldsOfJobClass) {
                    field.setAccessible(true);
                    if (field.isAnnotationPresent(WriteFormat.class)) {
                        WriteFormat writeFormat = field.getAnnotation(WriteFormat.class);
                        if (writeFormat.format() == CaseFormat.UPPER_CASE) {
                            temp = temp.concat(field.get(job).toString().toUpperCase().concat(","));
                        } else if (writeFormat.format() == CaseFormat.LOWER_CASE) {
                            temp = temp.concat(field.get(job).toString().toLowerCase().concat(","));
                        }
                    } else {
                        temp = temp.concat(field.get(job).toString().concat(","));
                    }
                }
                writer.write(temp.substring(0, temp.length() - 1).concat("\n"));
            }
            writer.close();
        } catch (IOException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

class MainRun {
    public static void main(String[] args) {
        Final finalExam = new Final("files/jobs-updated.csv");
        CustomFileWrite.writeReport("files/jobs-report.csv", finalExam.getJobs());
    }
}