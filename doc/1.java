    @RequestMapping(value = "/edit")
    public String editCinema(@RequestParam Map<String,String> RP, Model model) {
        Cinema cinema = CinemaDAO.findById(RP.get("id"));
        model.addAttribute("cinema", cinema);
        model.addAttribute("err", RP.get("err"));
        return "edit";
    }