/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.waleed.Home.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamShouldReturnLondonRecords() throws Exception {

        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("[[[{\"id\": 135, \"first_name\": \"Mechelle\", \"last_name\": \"Boam\", \"email\": \"mboam3q@thetimes.co.uk\", \"ip_address\": \"113.71.242.187\", \"latitude\": -6.5115909, \"longitude\": 105.652983}, {\"id\": 396, \"first_name\": \"Terry\", \"last_name\": \"Stowgill\", \"email\": \"tstowgillaz@webeden.co.uk\", \"ip_address\": \"143.190.50.240\", \"latitude\": -6.7098551, \"longitude\": 111.3479498}, {\"id\": 520, \"first_name\": \"Andrew\", \"last_name\": \"Seabrocke\", \"email\": \"aseabrockeef@indiegogo.com\", \"ip_address\": \"28.146.197.176\", \"latitude\": \"27.69417\", \"longitude\": \"109.73583\"}, {\"id\": 658, \"first_name\": \"Stephen\", \"last_name\": \"Mapstone\", \"email\": \"smapstonei9@bandcamp.com\", \"ip_address\": \"187.79.141.124\", \"latitude\": -8.1844859, \"longitude\": 113.6680747}, {\"id\": 688, \"first_name\": \"Tiffi\", \"last_name\": \"Colbertson\", \"email\": \"tcolbertsonj3@vimeo.com\", \"ip_address\": \"141.49.93.0\", \"latitude\": 37.13, \"longitude\": -84.08}, {\"id\": 794, \"first_name\": \"Katee\", \"last_name\": \"Gopsall\", \"email\": \"kgopsallm1@cam.ac.uk\", \"ip_address\": \"203.138.133.164\", \"latitude\": 5.7204203, \"longitude\": 10.901604}][{\"id\": 200, \"first_name\": \"Becka\", \"last_name\": \"Shaudfurth\", \"email\": \"bshaudfurth5j@bluehost.com\", \"ip_address\": \"18.55.237.174\", \"latitude\": 43.1581207, \"longitude\": -77.6063541}]]]"));
    }

    @Test
    public void manchesterParamsShouldReturnManchesterRecords() throws Exception {
        this.mockMvc.perform(get("/")
                .param("cityName","Manchester")
                .param("radius", "50"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("[[[{\"id\": 538, \"first_name\": \"Urban\", \"last_name\": \"Willcocks\", \"email\": \"uwillcocksex@hexun.com\", \"ip_address\": \"169.148.240.117\", \"latitude\": 40.7679191, \"longitude\": -93.3362962}]]]"));
    }

}
