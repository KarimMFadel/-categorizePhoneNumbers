import http from "../http-common";

const getAll = (params) => {
  return http.get("/customer/phoneNumbers", { params });
};

const CustomerService = {
  getAll,
};

export default CustomerService;
