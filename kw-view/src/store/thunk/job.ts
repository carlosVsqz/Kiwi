import {getJobCategories, getJobDetail, getJobs} from '@services/job';
import {GetJobCategoriesParams, GetJobListParams, jobActions} from '@store/slices/job';
import {Dispatch} from 'redux';

export const handleGetJob = (param: GetJobListParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(jobActions.getJobListRequest(param));
    const data = await getJobs(param);
    dispatch(jobActions.getJobListSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(jobActions.getJobListFailed(error.message));
  }
};

export const handleFooterJob = (param: GetJobListParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(jobActions.getFooterJobRequest(param));
    const data = await getJobs(param);
    dispatch(jobActions.getFooterJobSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(jobActions.getFooterJobFailed(error.message));
  }
};

export const handleGetJobDetail = (id: number) => async (dispatch: Dispatch) => {
  try {
    dispatch(jobActions.getJobDetailRequest());
    const {data} = await getJobDetail(id);
    dispatch(jobActions.getJobDetailSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(jobActions.getJobListFailed(error.message));
  }
};

export const handleJobsCategories = (param?: GetJobCategoriesParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(jobActions.getJobCategoriesRequest());
    const data = await getJobCategories(param);
    dispatch(jobActions.getJobCategoriesSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(jobActions.getJobCategoriesFailed(error.message));
  }
};

export const handleGetTrendingJob = (param: GetJobListParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(jobActions.getTrendingJobRequest());
    const data = await getJobs({...param, isTrending_like: true});
    dispatch(jobActions.getTrendingJobSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(jobActions.getTrendingJobFailed(error.message));
  }
};

export const handleGetDestinationJob = (param: GetJobListParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(jobActions.getDestinationJobRequest());
    const data = await getJobs(param);
    dispatch(jobActions.getDestinationJobSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(jobActions.getDestinationJobFailed(error.message));
  }
};

export const handleGetGuideJob = (param: GetJobListParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(jobActions.getGuideJobRequest());
    const data = await getJobs(param);
    dispatch(jobActions.getGuideJobSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(jobActions.getGuideJobFailed(error.message));
  }
};

export const handleGetLastestJob = (param: GetJobListParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(jobActions.getLastestJobRequest());
    const data = await getJobs(param);
    dispatch(jobActions.getLastestJobSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(jobActions.getLastestJobFailed(error.message));
  }
};

export const handleGetRelatedJob = (param: GetJobListParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(jobActions.getRelatedJobRequest());
    const data = await getJobs(param);
    dispatch(jobActions.getRelatedJobSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(jobActions.getRelatedtJobFailed(error.message));
  }
};
